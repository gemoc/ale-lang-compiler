package petrinet.benchmark.interpreter;

import java.util.Arrays;

import petrinet.interpreter.petrinet.Petrinet;

public class PetrinetBenchmarkInterpreter {
	public static void main(String[] args) {
		final int SIZE = 500;
		final long[] times = new long[SIZE];
		for (int i = 0; i < SIZE; i++) {
			Petrinet result = ModelFactory.chainOfOne(1000);
			final long start = System.currentTimeMillis();
			result.run();
			times[i] = System.currentTimeMillis() - start;
		}

		System.out.println(Arrays.toString(times));
	}
}
