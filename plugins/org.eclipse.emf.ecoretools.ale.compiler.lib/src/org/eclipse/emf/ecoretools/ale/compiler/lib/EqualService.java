package org.eclipse.emf.ecoretools.ale.compiler.lib;

import java.util.Objects;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public class EqualService {
	@TruffleBoundary
	public static boolean equals(Object a, Object b) {
		return Objects.equals(a, b);
	}
}
