package execboa;

import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.common.util.BasicEMap;

//import org.eclipse.emf.common.util.BasicEMap;
//import org.eclipse.emf.common.util.EMap;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public class MapService {
	@TruffleBoundary
	public static <K, V> void put(Map<K, V> map, K key, V value) {
		map.put(key, value);
	}

	@TruffleBoundary
	public static <K, V> void putAll(Map<K, V> map, Map<? extends K, ? extends V> all) {
		map.putAll(all);
	}

	@TruffleBoundary
	public static <K, V> void replaceWith(Map<K, V> map, Map<? extends K, ? extends V> all) {
		map.clear();
		map.putAll(all);
	}

	@TruffleBoundary
	public static <K, V> V getFromMap(Map<K, V> map, K key) {
		return map.get(key);
	}

	@TruffleBoundary
	public static <K, V> String mapToString(Map<K, V> map, Function<Map.Entry<K, V>, String> f) {
		String ret = "";
		for (Map.Entry<K, V> x : map.entrySet()) {
			ret += f.apply(x);
		}
		return ret;
	}

	@TruffleBoundary
	public static <K, V> boolean containsKey(Map<K, V> map, K key) {
		return map.containsKey(key);
	}

	@TruffleBoundary
	public static <K, V> Map<K, V> newMap(Object self) {
		return (Map<K, V>) new BasicEMap();
	}
}
