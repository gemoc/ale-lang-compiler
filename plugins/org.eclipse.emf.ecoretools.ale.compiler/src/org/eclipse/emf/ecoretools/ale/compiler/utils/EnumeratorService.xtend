package org.eclipse.emf.ecoretools.ale.compiler.utils

import java.util.stream.IntStream

class EnumeratorService {
	def <A> enumerate(Iterable<A> itt) {
		val ints = IntStream.range(0, itt.size).iterator
		itt.map[it -> ints.next]
	}
}
