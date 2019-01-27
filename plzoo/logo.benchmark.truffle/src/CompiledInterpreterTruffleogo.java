
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.util.Arrays;

public class CompiledInterpreterTruffleogo {
    public static String file;

    public static void main(final String[] args) {
        file = args[0];
        final int itt = Integer.parseInt(args[1]);
        EPackage.Registry.INSTANCE.put("http://kmLogo", KmLogoPackage.eINSTANCE);

        LogService.MUTE = true;
        
        Context context = Context.create();
        final int SIZE = itt;
        final long[] times = new long[SIZE];
        for (int i = 0; i < SIZE; i++) {
            Value eval = context.eval("logo", "");
            times[i] = eval.asLong();
        }
        context.close();

        System.out.println(Arrays.toString(times));
    }
}
