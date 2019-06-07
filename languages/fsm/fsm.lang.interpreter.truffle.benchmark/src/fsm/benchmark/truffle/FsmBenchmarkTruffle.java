package fsm.benchmark.truffle;

import java.util.Arrays;

import org.eclipse.emf.ecore.EPackage;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import fsm.interpreter.fsm.FsmPackage;

public class FsmBenchmarkTruffle {
	static String file;

	public static void main(final String[] args) {

		file = args[0];
		final int itt = Integer.parseInt(args[1]);

		EPackage.Registry.INSTANCE.put("http://www.example.org/fsm", FsmPackage.eINSTANCE);

		final int SIZE = itt;
		final long[] times = new long[SIZE];
		Context context = Context.create();
		for (int i = 0; i < SIZE; i++) {
			Value eval = context.eval("fsm", String.valueOf(0));
			times[i] = eval.asLong();
		}
		context.close();

		System.out.println(Arrays.toString(times));
	}
}
