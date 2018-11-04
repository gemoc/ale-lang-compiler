package kmLogo.interpreter.kmLogo.extra;


import java.lang.reflect.Array;
import java.util.List;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public class ArrayService {
	@SuppressWarnings("unchecked")
	@TruffleBoundary
	public static <T> T[] toArray(Class<T> clazz, List<T> t) {
		T[] ts = (T[]) Array.newInstance(clazz, t.size());
		return t.toArray(ts);
	}
}
