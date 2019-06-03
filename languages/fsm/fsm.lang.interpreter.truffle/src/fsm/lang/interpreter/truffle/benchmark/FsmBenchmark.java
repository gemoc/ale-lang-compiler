package fsm.lang.interpreter.truffle.benchmark;

import java.util.Arrays;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;


public class FsmBenchmark {

	public static String file;
	public static void main(final String[] args) {
        file = args[0];
        final int itt = Integer.parseInt(args[1]);
//        EPackage.Registry.INSTANCE.put("http://kmLogo", FsmPackage.eINSTANCE);

        Context context = Context.create();
        final int SIZE = itt;
        final long[] times = new long[SIZE];
        for (int i = 0; i < SIZE; i++) {
            Value eval = context.eval("fsm", "");
            times[i] = eval.asLong();
        }
        context.close();

        System.out.println(Arrays.toString(times));
    }
}
