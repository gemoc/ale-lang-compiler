package org.eclipse.emf.ecoretools.ale.compiler.lib;

public class LogService {

	public static final StringBuilder sb = new StringBuilder();
	public static boolean TOSDTOUT = true;

	public static void log(Object log) {
		if (TOSDTOUT)
			System.out.println(log);
		else {
			sb.append(log);
			sb.append(System.lineSeparator());
		}

	}
}
