
import java.util.Arrays;

import org.eclipse.emf.ecore.EPackage;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import kmLogo.interpreter.kmLogo.KmLogoPackage;

public class CompiledInterpreterTruffleLogoAlLDispatch {
    public static String file;

    public static void main(final String[] args) {
        file = args[0];
        final int itt = Integer.parseInt(args[1]);
        EPackage.Registry.INSTANCE.put("http://kmLogo", KmLogoPackage.eINSTANCE);

        Context context = Context.create();
        final int SIZE = itt;
        final long[] times = new long[SIZE];
        for (int i = 0; i < SIZE; i++) {
            Value eval = context.eval("logo", String.valueOf(i));
            times[i] = eval.asLong();
        }
        context.close();

        System.out.println(Arrays.toString(times));
    }
}
