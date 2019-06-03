package execboa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializeService {
	public static String serialize(final Object o) {

		final String name = o.getClass().getName();
		if (name.contains("EvalIntRes")) {
			return serializeInt(o);
		} else if (name.contains("EvalMapRes")) {
			return serializeMap(o);
		} else if (name.contains("EvalFunRes")) {
			return "<fun>";
		} else if (name.contains("EvalBoolRes")) {
			return serializeBool(o);
		}

		return "";

	}

	private static String serializeBool(final Object o) {
		try {
			final Method m = o.getClass().getMethod("isValue");
			return String.valueOf(m.invoke(o));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			return "";
		}
	}

	private static String serializeMap(final Object o) {
		try {
			final Method m = o.getClass().getMethod("getValues");
			final List invoke = (List) m.invoke(o);
			final Map<Object, Object> res = new HashMap<>();

			for (final Object x : invoke) {
				final Map.Entry e = (Map.Entry) x;
				res.put(String.valueOf(e.getKey()), serialize(e.getValue()));
			}
			return String.valueOf(res);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			return "";
		}
	}

	private static String serializeInt(final Object o) {
		try {
			final Method m = o.getClass().getMethod("getValue");
			return String.valueOf(m.invoke(o));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			return "";
		}
	}
}
