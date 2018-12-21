package minijava;

import java.util.ArrayList;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

@SuppressWarnings("all")
public class MiniJavaPerfTest {
	public static String file;

	public static void main(final String[] args) {
		MiniJavaPerfTest.file = args[0];
		final int itt = Integer.parseInt(args[1]);
		final int cptr = 1;
		final Context context = Context.create();
		final ArrayList<Long> results = new ArrayList<>();
		for (int i = 0; (i < cptr); i++) {
			final Value res = context.eval("miniJava", Integer.valueOf(i).toString());
			results.add(Long.valueOf(res.asLong()));
		}
		boolean _hasElements = false;
		for (final Long i : results) {
			if (!_hasElements) {
				_hasElements = true;
				System.out.print("[");
			} else {
				System.out.print(", ");
			}
			System.out.print(i);
		}
		if (_hasElements) {
			System.out.println("]");
		}
	}
}
