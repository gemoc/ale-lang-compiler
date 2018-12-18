package boa.benchmark.truffle;

import java.util.Arrays;

import org.eclipse.emf.ecore.EPackage;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import boa.interpreter.boa.BoaPackage;

public class BoaBenchmarkTruffle {
	static String file;

	public static void main(final String[] args) {

		file = args[0];
		final int itt = Integer.parseInt(args[1]);

		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE);

		final int SIZE = itt;
		final long[] times = new long[SIZE];
		final Context context = Context.create();
		for (int i = 0; i < SIZE; i++) {
			final Value eval = context.eval("boa", String.valueOf(i));
			times[i] = eval.asLong();
		}
		context.close();

		System.out.println(Arrays.toString(times));
	}
}
