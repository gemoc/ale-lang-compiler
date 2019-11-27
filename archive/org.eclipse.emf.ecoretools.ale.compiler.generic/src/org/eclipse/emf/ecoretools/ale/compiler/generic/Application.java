package org.eclipse.emf.ecoretools.ale.compiler.generic;

import com.google.inject.Inject;
import com.google.inject.Injector;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.engine.*;
import io.jenetics.util.ISeq;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.AleStandaloneSetup;
import org.eclipse.emf.ecoretools.ale.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.Operation;
import org.eclipse.emf.ecoretools.ale.Unit;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

	static final class MethodRef {
		String className;
		String methodName;

		MethodRef(final String className, final String methodName) {
			super();
			this.className = className;
			this.methodName = methodName;
		}

		@Override
		public String toString() {
			return className + "." + methodName;
		}

	}

	private final static List<MethodRef> features = Arrays.asList(new MethodRef("Program", "main"),
			new MethodRef("Program", "initialize"), new MethodRef("Program", "execute"),
			new MethodRef("Program", "findMain"), new MethodRef("Statement", "evaluateStatement"),
			new MethodRef("Block", "evaluateStatementKeepContext"), new MethodRef("Block", "evaluateStatement"),
			new MethodRef("Assignment", "evaluateStatement"), new MethodRef("PrintStatement", "evaluateStatement"),
			new MethodRef("ForStatement", "evaluateStatement"), new MethodRef("IfStatement", "evaluateStatement"),
			new MethodRef("WhileStatement", "evaluateStatement"), new MethodRef("Return", "evaluateStatement"),
			new MethodRef("Method", "evaluateStatement"), new MethodRef("Method", "findOverride"),
			new MethodRef("Method", "call"), new MethodRef("Expression", "evaluateStatement"),
			new MethodRef("Expression", "evaluateExpression"), new MethodRef("This", "evaluateExpression"),
			new MethodRef("BoolConstant", "evaluateExpression"), new MethodRef("IntConstant", "evaluateExpression"),
			new MethodRef("StringConstant", "evaluateExpression"), new MethodRef("And", "evaluateExpression"),
			new MethodRef("Or", "evaluateExpression"), new MethodRef("ArrayAccess", "evaluateExpression"),
			new MethodRef("ArrayLength", "evaluateExpression"), new MethodRef("Division", "evaluateExpression"),
			new MethodRef("Minus", "evaluateExpression"), new MethodRef("Multiplication", "evaluateExpression"),
			new MethodRef("Modulo", "evaluateExpression"), new MethodRef("Equality", "evaluateExpression"),
			new MethodRef("FieldAccess", "evaluateExpression"), new MethodRef("Inequality", "evaluateExpression"),
			new MethodRef("Inferior", "evaluateExpression"), new MethodRef("SuperiorOrEqual", "evaluateExpression"),
			new MethodRef("Superior", "evaluateExpression"), new MethodRef("Plus", "evaluateExpression"),
			new MethodRef("Null", "evaluateExpression"), new MethodRef("Neg", "evaluateExpression"),
			new MethodRef("Not", "evaluateExpression"), new MethodRef("InferiorOrEqual", "evaluateExpression"),
			new MethodRef("MethodCall", "evaluateExpression"), new MethodRef("MethodCall", "call"),
			new MethodRef("SymbolRef", "evaluateExpression"), new MethodRef("NewArray", "evaluateExpression"),
			new MethodRef("NewObject", "evaluateExpression"), new MethodRef("State", "findCurrentFrame"),
			new MethodRef("State", "findCurrentContext"), new MethodRef("State", "pushNewContext"),
			new MethodRef("State", "popCurrentContext"), new MethodRef("State", "println"),
			new MethodRef("State", "pushNewFrame"), new MethodRef("State", "popCurrentFrame"),
			new MethodRef("Frame", "findCurrentContext"), new MethodRef("Frame", "findCurrentFrame"),
			new MethodRef("Context", "findBinding"), new MethodRef("Context", "findCurrentContext"),
			new MethodRef("Value", "customToString"), new MethodRef("Value", "copyj"),
			new MethodRef("ObjectRefValue", "customToString"), new MethodRef("ObjectRefValue", "copyj"),
			new MethodRef("ArrayRefValue", "copyj"), new MethodRef("ArrayRefValue", "customToString"),
			new MethodRef("IntegerValue", "customToString"), new MethodRef("IntegerValue", "copyj"),
			new MethodRef("BooleanValue", "customToString"), new MethodRef("BooleanValue", "copyj"),
			new MethodRef("StringValue", "customToString"), new MethodRef("StringValue", "copyj"),
			new MethodRef("NullValue", "copyj"), new MethodRef("TypeRef", "compare"),
			new MethodRef("ClassRef", "compare"), new MethodRef("Parameter", "compare"));

	final class Pair<K, V> {
		final K key;
		final V value;

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
		final Engine<BitGene, Double> engine = Engine.builder(fitness(alePath), codec).minimizing()
				.executor(Executors.newSingleThreadExecutor()).build();
		final Genotype<BitGene> best = engine.stream().limit(20000).collect(EvolutionResult.toBestGenotype());
		System.out.println(best);
		System.out.println(codec.decode(best));
		System.out.println(CACHE);

	}

	private Function<ISeq<MethodRef>, Double> fitness(final String alePath) {
		return t -> {
			System.out.println(t);
			final String key = t.stream().map(Object::toString).collect(Collectors.joining("_"));
			if (!CACHE.containsKey(key)) {
				try {
					mutate(alePath, t);
					bench(key);
				} catch (final Exception e) {
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

			ret = results.stream().skip(10).mapToDouble(Double::valueOf).average().orElse(Double.MAX_VALUE);

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
		try {
			final Resource res = resourceSet.getResource(URI.createFileURI(alePath), true);

			if (res.getContents().isEmpty()) {
				res.getContents().add(EcoreUtil.copy(this.backup));
			}

			final Unit u = ((Unit) res.getContents().get(0));

			if (this.backup == null) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() {
//		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
		final Injector injector = new AleStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	}
}
