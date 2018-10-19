package org.eclipse.emf.ecoretools.ale.compiler.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

public class CollectionService {

	public static <T> EList<T> createEList(T... ts) {
		return new BasicEList<>(Arrays.asList(ts));
	}

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

	public static <T> T get(final Iterable<T> collection, int idx) {
		final Iterator<T> iterator = collection.iterator();
		T ret = null;
		for (int i = 0; i < idx; i++) {
			if (iterator.hasNext())
				ret = iterator.next();
			else
				return null;
		}

		return ret;
	}

	public static <T> boolean isEmpty(final Iterable<T> collection) {
		final Iterator<T> iterator = collection.iterator();
		if (iterator.hasNext())
			return false;
		else
			return true;
	}
}
