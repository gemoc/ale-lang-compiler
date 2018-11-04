package boa.benchmark.truffle;

import java.util.Arrays;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class CompiledInterpreterTruffleBoaFib {
	public static void main(final String[] args) {

		final int SIZE = 2000;
		final long[] times = new long[SIZE];
		Context context = Context.create();
		for (int i = 0; i < SIZE; i++) {
			Value eval = context.eval("boa", String.valueOf(0));
			times[i] = eval.asLong();
		}
		context.close();

		System.out.println(Arrays.toString(times));
	}
}
