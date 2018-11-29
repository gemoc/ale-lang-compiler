package org.eclipse.emf.ecoretools.ale.compiler.generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.AleStandaloneSetup;
import org.eclipse.emf.ecoretools.ale.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.Operation;
import org.eclipse.emf.ecoretools.ale.Unit;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Injector;

import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.engine.Codec;
import io.jenetics.engine.Codecs;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.engine.Limits;
import io.jenetics.util.ISeq;

public class Application {

	static final class MethodRef {
		String className;
		String methodName;

		public MethodRef(final String className, final String methodName) {
			super();
			this.className = className;
			this.methodName = methodName;
		}

		@Override
		public String toString() {
			return className + "." + methodName;
		}

	}

	final static List<MethodRef> features = Arrays.asList(new MethodRef[] { new MethodRef("boa.File", "eval"),
			new MethodRef("boa.TopLevelCmd", "nextLine"), new MethodRef("boa.Def", "nextLine"),
			new MethodRef("boa.Expr", "eval"), new MethodRef("boa.Expr", "nextLine"), new MethodRef("boa.Var", "eval"),
			new MethodRef("boa.BObject", "eval"), new MethodRef("boa.App", "eval"),
			new MethodRef("boa.App", "callFunc"), new MethodRef("boa.ArithOpDivide", "eval"),
			new MethodRef("boa.ArithOpMinus", "eval"), new MethodRef("boa.ArithOpPlus", "eval"),
			new MethodRef("boa.ArithOpRemainder", "eval"), new MethodRef("boa.ArithOpTimes", "eval"),
			new MethodRef("boa.Assign", "eval"), new MethodRef("boa.Bool", "eval"),
			new MethodRef("boa.BoolOpAnd", "eval"), new MethodRef("boa.BoolOpOr", "eval"),
			new MethodRef("boa.CmpOpEqual", "eval"), new MethodRef("boa.CmpOpUnequal", "eval"),
			new MethodRef("boa.CmpOpLess", "eval"), new MethodRef("boa.Copy", "eval"), new MethodRef("boa.Fun", "eval"),
			new MethodRef("boa.If", "eval"), new MethodRef("boa.Int", "eval"), new MethodRef("boa.Let", "eval"),
			new MethodRef("boa.Not", "eval"), new MethodRef("boa.Project", "eval"),
			new MethodRef("boa.Project", "project"), new MethodRef("boa.Seq", "eval"),
			new MethodRef("boa.Skip", "eval"), new MethodRef("boa.This", "eval"), new MethodRef("boa.With", "eval")

	});

	final class Pair<K, V> {
		public final K key;
		public final V value;

		Pair(final K k, final V v) {
			this.key = k;
			this.value = v;
		}

		@Override
		public String toString() {
			return "Pair [key=" + key + ", value=" + value + "]";
		}

	}

	private static int itt;

	private static String root;

	@Inject
	private XtextResourceSet resourceSet;

	private Unit backup;

	private final static Map<String, Pair<Double, List<Long>>> CACHE = new HashMap<>();

	public static void main(final String[] args) throws NumberFormatException, IOException {
		itt = Integer.parseInt(args[1]);
		root = args[2];
		new Application().run(args[0]);
	}

	private void run(final String alePath) throws IOException {
		init();

		// encode the fact that any combinations must bon concidered
		System.out.println(features);
		final Codec<ISeq<MethodRef>, BitGene> codec = Codecs.ofSubSet(features.stream().collect(ISeq.toISeq()));
		final Engine<BitGene, Double> engine = Engine.builder(fitness(alePath), codec)
				// default population size = 50
				.populationSize(20).executor(Executors.newSingleThreadExecutor()).build();
		final Genotype<BitGene> best = engine.stream().limit(Limits.bySteadyFitness(7)).limit(20)
				.collect(EvolutionResult.toBestGenotype());
		System.out.println(best);
		System.out.println(codec.decode(best));
		System.out.println(CACHE);

	}

	private Function<ISeq<MethodRef>, Double> fitness(final String alePath) {
		return t -> {
			final String key = t.stream().map(Object::toString).collect(Collectors.joining("_"));
			if (!CACHE.containsKey(key)) {
				try {
					mutate(alePath, t);
					bench(key);
				} catch (final IOException e) {
					return Double.MAX_VALUE;
				}
			}

			return CACHE.get(key).key;

		};
	}

	private double bench(final String key) {
		final ProcessBuilder pb = new ProcessBuilder(root + "/build_single.sh", key, String.valueOf(itt), root);

		Double ret = null;
		List<Long> results = null;

		try {
			final Process s = pb.start();
			s.waitFor();
			final String lastLine = getLastLine(s);

			final String substring = lastLine.substring(1, lastLine.length() - 1);
			final List<String> asList = Arrays.asList(substring.split(","));
			results = asList.stream().map(String::trim).map(Long::parseLong).collect(Collectors.toList());

			ret = results.stream().skip(10).mapToDouble(x -> Double.valueOf(x)).average().orElse(Double.MAX_VALUE);

		} catch (final Exception e) {
			ret = Double.MAX_VALUE;
		}
		CACHE.put(key, new Pair<Double, List<Long>>(ret, results));

		return ret;

	}

	private String getLastLine(final Process s) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		final List<String> lines = reader.lines().collect(Collectors.toList());
		return lines.get(lines.size() - 1);
	}

	private void mutate(final String alePath, final ISeq<MethodRef> t) throws IOException {
		final Resource res = resourceSet.getResource(URI.createFileURI(alePath), true);

		if(res.getContents().isEmpty()) {
			res.getContents().add(EcoreUtil.copy(this.backup));
		}
		
		final Unit u = ((Unit) res.getContents().get(0));
		
		if(this.backup == null) {
			this.backup = EcoreUtil.copy(u);
		}
		
		final Stream<Operation> s = u.getXtendedClasses().stream().flatMap(x -> x.getOperations().stream());

		s.forEach(o -> {
			final Stream<MethodRef> filter = t.stream().filter(p -> {
				final boolean equals = p.className.equals(((ExtendedClass) o.eContainer()).getName());
				final boolean equals2 = p.methodName.equals(o.getName());
				return equals && equals2;
			});
			final Optional<MethodRef> findAny = filter.findAny();
			final boolean present = findAny.isPresent();
			o.setDispatch(present);
		});

		res.save(null);
	}

	private void init() {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
		final Injector injector = new AleStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	}
}
