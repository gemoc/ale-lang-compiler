package org.eclipse.emf.ecoretools.ale.compiler.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public class CollectionService {

	@TruffleBoundary
	public static <T> EList<T> createEList(T... ts) {
		return new BasicEList<>(Arrays.asList(ts));
	}

	@TruffleBoundary
	public static <T> int size(final Iterable<T> collection) {
		int ret = 0;
		for (Object x : collection) {
			ret++;
		}

		return ret;
	}

	@TruffleBoundary
	public static <T> Iterable<T> select(final Iterable<T> collection, final Function<? super T, Boolean> filter) {
		final ArrayList<T> ret = new ArrayList<>();
		for (final T e : collection) {
			if (filter.apply(e))
				ret.add(e);
		}
		return ret;
	}

	@TruffleBoundary
	public static <T> T head(final Iterable<T> collection) {
		final Iterator<T> iterator = collection.iterator();
		if (iterator.hasNext())
			return iterator.next();
		else
			return null;
	}

	@TruffleBoundary
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

	@TruffleBoundary
	public static <T> boolean isEmpty(final Iterable<T> collection) {
		final Iterator<T> iterator = collection.iterator();
		if (iterator.hasNext())
			return false;
		else
			return true;
	}
}
