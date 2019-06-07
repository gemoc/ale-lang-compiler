package org.eclipse.emf.ecoretools.ale.compiler.lib;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public class LogService {

	public static final StringBuilder sb = new StringBuilder();
	public static boolean TOSDTOUT = true;
	public static boolean MUTE = false;

	@TruffleBoundary
	public static void log(Object log) {
		if (!MUTE) {
			if (TOSDTOUT)
				System.out.println(log);
			else {
				sb.append(log);
				sb.append(System.lineSeparator());
			}
		}

	}
}
