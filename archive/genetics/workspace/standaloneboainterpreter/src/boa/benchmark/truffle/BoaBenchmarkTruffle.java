package boa.benchmark.truffle;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.util.Arrays;

public class BoaBenchmarkTruffle {
//    static String file;

    public static void main(final String[] args) {
//        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
//        List<String> arguments = runtimeMxBean.getInputArguments();
//        System.out.println(arguments);
//        System.out.println(Arrays.toString(args));
        String file = args[0];
        final int itt = Integer.parseInt(args[1]);

        final int SIZE = itt;
        final long[] times = new long[SIZE];
        Context context = Context.create();
        for (int i = 0; i < SIZE; i++) {
            Value eval = context.eval("boa", file + ";" + i);
            times[i] = eval.asLong();
        }
        context.close();

        System.out.println(Arrays.toString(times));
    }
}
