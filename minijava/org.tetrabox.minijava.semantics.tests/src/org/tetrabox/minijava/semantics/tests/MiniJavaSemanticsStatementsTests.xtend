/*
 * generated by Xtext 2.12.0
 */
package org.tetrabox.minijava.semantics.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.tetrabox.minijava.semantics.tests.util.MiniJavaTestUtil
import org.tetrabox.minijava.xtext.tests.MiniJavaInjectorProvider

import org.tetrabox.minijava.semantics.tests.util.MiniJavaValueEquals.ObjectTemplate
import org.tetrabox.minijava.semantics.tests.util.MiniJavaValueEquals.ArrayTemplate
import org.tetrabox.minijava.semantics.tests.util.DumpUtil

@RunWith(XtextRunner)
@InjectWith(MiniJavaInjectorProvider)
class MiniJavaSemanticsStatementsTests {
	@Inject
	extension MiniJavaTestUtil testUtil

	@Test
	def void PrintStatement_single() {
		genericStatementPrintTest('''System.out.println("Hello!");''', "Hello!")
	}

	@Test
	def void PrintStatement_multiple() {
		genericStatementPrintTest('''System.out.println("Hello!"); System.out.println("World!");''', "Hello!", "World!")
	}

	@Test
	def void IfStatement_noelse_true() {
		genericStatementPrintTest('''if (true) { System.out.println("then"); }''', "then")
	}

	@Test
	def void IfStatement_noelse_false() {
		genericStatementPrintTest('''if (false) { System.out.println("then"); }''', #[])
	}

	@Test
	def void IfStatement_else_true() {
		genericStatementPrintTest('''if (true) { System.out.println("then"); } else { System.out.println("else");}''',
			"then")
	}

	@Test
	def void IfStatement_else_false() {
		genericStatementPrintTest('''if (false) { System.out.println("then"); } else { System.out.println("else");}''',
			"else")
	}

	@Test
	def void WhileStatement_fewsteps() {
		genericStatementPrintTest('''
			int i = 0;
			while (i < 5) { 
				System.out.println("x");
				i = i +1;
			}
		''', "x", "x", "x", "x", "x")
	}

	@Test
	def void WhileStatement_false() {
		genericStatementPrintTest('''
			while (false) { 
				System.out.println("x");
			}
		''', #[])
	}

	@Test
	def void ForStatement_fewstep() {
		genericStatementPrintTest('''
			for (int i = 0; i < 5; i = i+1) {
				System.out.println("x");
			}
		''', "x", "x", "x", "x", "x")
	}

	@Test
	def void ForStatement_conditionfalse() {
		genericStatementPrintTest('''
			for (int i = 0; i > 5; i = i+1) {
				System.out.println("x");
			}
		''', #[])
	}

	@Test
	def void Assignment_declaration_int() {
		genericStatementBindingsTest("int x = 12;", #{"x" -> 12})
	}

	@Test
	def void Assignment_declaration_int_sum() {
		genericStatementBindingsTest("int x = 12+6;", #{"x" -> 18})
	}

	@Test
	def void Assignment_field() {
		DumpUtil.DUMP = true
		genericStatementBindingsTest("X y = new X(); y.i = 76;", #{"y" -> new ObjectTemplate("X", #{"i" -> 76})})
		DumpUtil.DUMP = false
	}

	@Test
	def void Assignment_reassignment_int() {
		genericStatementBindingsTest(
			'''
				int x = 12+6;
				x = -9;
			''',
			#{"x" -> -9}
		)

	}

	@Test
	def void Assignment_array() {
		genericStatementBindingsTest("int[] array = new int[3]; ",
			#{"array" -> new ArrayTemplate(3, "int", #[0, 0, 0])})
	}

	def void Assignment_array_entry() {
		genericStatementBindingsTest("int[] array = new int[2]; array[1] = 87;",
			#{"array" -> new ArrayTemplate(2, "int", #[0, 87])})
	}

	@Test
	def void methodCall_print() {
		genericStatementPrintTest('''X test = new X(); test.hello(); ''', "hello")
	}

	@Test
	def void methodCall_changefield() {
		genericStatementBindingsTest('''X test = new X(); test.i = 78; test.increment(3); ''',
			#{"test" -> new ObjectTemplate("X", #{"i" -> 81})})
	}

}
