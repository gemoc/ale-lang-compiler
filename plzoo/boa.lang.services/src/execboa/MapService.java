package execboa;

import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public class MapService {
	@TruffleBoundary
	public static <K, V> void put(EMap<K, V> map, K key, V value) {
		map.put(key, value);
	}

	@TruffleBoundary
	public static <K, V> void putAll(EMap<K, V> map, EMap<? extends K, ? extends V> all) {
		map.putAll(all);
	}

	@TruffleBoundary
	public static <K, V> void replaceWith(EMap<K, V> map, EMap<? extends K, ? extends V> all) {
		map.clear();
		map.putAll(all);
	}

	@TruffleBoundary
	public static <K, V> V getFromMap(EMap<K, V> map, K key) {
		return map.get(key);
	}

	@TruffleBoundary
	public static <K, V> String mapToString(EMap<K, V> map, Function<Map.Entry<K, V>, String> f) {
		String ret = "";
		for (Map.Entry<K, V> x : map.entrySet()) {
			ret += f.apply(x);
		}
		return ret;
	}

	@TruffleBoundary
	public static <K, V> boolean containsKey(EMap<K, V> map, K key) {
		return map.containsKey(key);
	}

	@TruffleBoundary
	public static <K, V> EMap<K, V> newMap(Object self) {
		return new BasicEMap<>();
	}
}
