package execboa;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

public class MapService {

	@SuppressWarnings("unchecked")
	public static <K, V> void put(EMap<K, V> map, K key, V value) {
		map.put(key, value);
	}

	public static <K, V> void putAll(EMap<K, V> map, EMap<? extends K, ? extends V> all) {
		map.putAll(all);
	}
	
	public static <K, V> void replaceWith(EMap<K, V> map, EMap<? extends K, ? extends V> all) {
		map.clear();
		map.putAll(all);
	}

	public static <K, V> V getFromMap(EMap<K, V> map, K key) {
		return map.get(key);
	}

	public static <K, V> boolean containsKey(EMap<K, V> map, K key) {
		return map.containsKey(key);
	}

	public static <K, V> EMap<K, V> newMap(Object self) {
		return new BasicEMap<>();
	}
}
