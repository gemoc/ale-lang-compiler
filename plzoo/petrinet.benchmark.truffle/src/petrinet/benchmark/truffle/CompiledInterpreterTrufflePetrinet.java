package petrinet.benchmark.truffle;

import java.util.Arrays;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class CompiledInterpreterTrufflePetrinet {
	public static void main(final String[] args) {

		final int SIZE = 500;
		final long[] times = new long[SIZE];
		Context context = Context.create();
		for (int i = 0; i < SIZE; i++) {
			Value eval = context.eval("petrinet", String.valueOf(i));
			times[i] = eval.asLong();
		}
		context.close();

		System.out.println(Arrays.toString(times));
	}
}
