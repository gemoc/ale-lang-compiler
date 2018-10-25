package execboa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SerializeService {
	public static String serialize(Object o) {

		String name = o.getClass().getName();
		if (name.contains("EvalIntRes")) {
			return serializeInt(o);
		} else if (name.contains("EvalMapRes")) {
			return serializeMap(o);
		} else if (name.contains("EvalFunRes")) {
			return "<fun>";
		}else if(name.contains("EvalBoolRes")) {
			return serializeBool(o);
		}

		return "";

	}

	private static String serializeBool(Object o) {
		try {
			Method m = o.getClass().getMethod("isValue");
			return String.valueOf(m.invoke(o));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			return "";
		}
	}

	private static String serializeMap(Object o) {
		try {
			Method m = o.getClass().getMethod("getValues");
			List invoke = (List) m.invoke(o);
			Map<Object, Object> res = new HashMap<>();

			for (Object x : invoke) {
				Map.Entry e = (Map.Entry) x;
				res.put(String.valueOf(e.getKey()), serialize(e.getValue()));
			}
//			for(Map.Entry x: ) {
//				
//			}
			return String.valueOf(res);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			return "";
		}
	}

	private static String serializeInt(Object o) {
		try {
			Method m = o.getClass().getMethod("getValue");
			return String.valueOf(m.invoke(o));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			return "";
		}
	}
}
