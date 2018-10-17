package org.eclipse.emf.ecoretools.ale.compiler.lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

public class CollectionService {
	public static <T> Iterable<T> select(final Iterable<T> collection, final Function<? super T, Boolean> filter) {
		final ArrayList<T> ret = new ArrayList<>();
		for (final T e : collection) {
			if (filter.apply(e))
				ret.add(e);
		}
		return ret;
	}

	public static <T> T head(final Iterable<T> collection) {
		final Iterator<T> iterator = collection.iterator();
		if (iterator.hasNext())
			return iterator.next();
		else
			return null;
	}

	public static <T> boolean isEmpty(final Iterable<T> collection) {
		final Iterator<T> iterator = collection.iterator();
		if (iterator.hasNext())
			return false;
		else
			return true;
	}
}
