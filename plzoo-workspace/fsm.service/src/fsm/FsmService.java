package fsm;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public class FsmService {

	@TruffleBoundary
	public static int indexOf(String s, String sep) {
		return s.indexOf(sep);
	}

	@TruffleBoundary
	public static String substring(String s, int beginIndex, int endIndex) {
		return s.substring(beginIndex, endIndex);
	}
}
