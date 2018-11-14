
import java.util.Arrays;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class CompiledInterpreterTruffleogo {
	public static void main(final String[] args) {

		LogService.MUTE = true;
		Context context = Context.create();
		final int SIZE = 100;
		final long[] times = new long[SIZE];
		for (int i = 0; i < SIZE; i++) {
			Value eval = context.eval("logo", String.valueOf(i));
			times[i] = eval.asLong();
		}
		context.close();

		System.out.println(Arrays.toString(times));
	}
}
