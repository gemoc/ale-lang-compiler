package org.tetrabox.minijava.perfs

import org.graalvm.polyglot.Context

class MiniJavaPerfTest {
	public var static String file;

	def static void main(String[] args) {

		file = args.get(0);
		val itt = Integer.parseInt(args.get(1));

		val cptr = 1;
		val context = Context.create();
		val results = newArrayList
		for (var i = 0; i < cptr; i++) {
			val res = context.eval('miniJava', i.toString);
			results.add(res.asLong)
		}
		println('''«FOR i : results BEFORE '[' SEPARATOR ', ' AFTER ']'»«i»«ENDFOR»''')
	}
}
