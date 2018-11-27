package imp.benchmark.truffle;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import interpreter.imp.interpreter.imp.ArrayValue;
import interpreter.imp.interpreter.imp.ImpFactory;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.IntValue;
import interpreter.imp.interpreter.imp.Store;

public class ImpBenchmarkTruffle {
	static String file;

	public static void main(final String[] args) {

		file = args[0];
		final int itt = Integer.parseInt(args[1]);

		final int SIZE = itt;
		final long[] times = new long[SIZE];
		Context context = Context.create();
		for (int i = 0; i < SIZE; i++) {
			Value eval = context.eval("imp", String.valueOf(i));
			times[i] = eval.asLong();
		}
		context.close();

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

	static Store initState(final int size) {
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
