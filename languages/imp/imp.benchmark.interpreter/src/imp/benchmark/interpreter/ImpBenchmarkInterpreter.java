package imp.benchmark.interpreter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import interpreter.imp.interpreter.imp.ArrayValue;
import interpreter.imp.interpreter.imp.ImpFactory;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.IntValue;
import interpreter.imp.interpreter.imp.Stmt;
import interpreter.imp.interpreter.imp.Store;

public class ImpBenchmarkInterpreter {
	public static void main(final String[] args) {
		final String file = args[0];
		final int itt = Integer.parseInt(args[1]);
//		final int itt = 200;

		EPackage.Registry.INSTANCE.put("http://www.example.org/imp", ImpPackage.eINSTANCE);

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		final long[] times = new long[itt];

		for (int i = 0; i < itt; i++) {

			final ResourceSetImpl resSet = new ResourceSetImpl();
			final URI createFileURI = URI.createFileURI(file);
			final Resource resource = resSet.getResource(createFileURI, true);
			final Stmt result = (Stmt) resource.getContents().get(0);

			final Store s = initState(500);
			final long start = System.currentTimeMillis();
			final Store sorted = result.execute(s);
			times[i] = System.currentTimeMillis() - start;

//			final ArrayValue arrayValue = (ArrayValue) sorted.getValues().get("a");
//			final List<Integer> arr = arrayValue.getValues().stream().map(x -> ((IntValue) x).getValue())
//					.collect(Collectors.toList());
//			System.out.println("For " + i);
//			System.out.println(isSorted(arr));
//			System.out.println(arr.size());
//			System.out.println("Time = " + times[i]);
		}

		System.out.println(Arrays.toString(times));

	}

	private static boolean isSorted(final List<Integer> a) {
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i) > a.get(i + 1)) {
				return false;
			}
		}
		return true;

	}

	private static Store initState(final int size) {
		final ImpFactory f = ImpFactory.eINSTANCE;
		final Store s = f.createStore();

		final ArrayValue ai = f.createArrayValue();
		for (int idx = size; idx > 0; idx--) {
			final IntValue v = f.createIntValue();
			v.setValue(idx);
			ai.getValues().add(v);
		}
		s.getValues().put("a", ai);
		final IntValue ni = f.createIntValue();
		ni.setValue(ai.getValues().size());
		s.getValues().put("n", ni);
		return s;
	}
}
