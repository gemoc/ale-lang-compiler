package org.tetrabox.minijava.semantics.tests.util

import com.google.inject.Inject
import java.util.Map
import java.util.Set
import java.util.function.Consumer
import miniJava.visitor.miniJava.Context
import miniJava.visitor.miniJava.MiniJavaFactory
import miniJava.visitor.miniJava.MiniJavaPackage
import miniJava.visitor.miniJava.Program
import miniJava.visitor.miniJava.State
import miniJava.visitor.miniJava.SymbolBinding
import miniJava.visitor.miniJava.Value
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.tetrabox.minijava.xtext.tests.MiniJavaInjectorProvider
import visitor.VisitorImplementation
import visitor.operation.miniJava.ExpressionOperation
import visitor.operation.miniJava.impl.ProgramOperationImpl

@InjectWith(MiniJavaInjectorProvider)
class MiniJavaTestUtil {

	@Inject
	ParseHelper<Program> parseHelper

	public static val String intTypeName = "int"
	public static val String booleanTypeName = "boolean"
	public static val String stringTypeName = "String"
	
	val visitor = new VisitorImplementation()

	public def static String prepareTestProgram(String mainContent) {
		'''
		
		interface I {
			public void hello();
		}
		
		class X implements I{
			public int i;
			public boolean b;
			public String s;
			
			public X(int j) {
				this.i = j;
			}
			
			public int identity(int j) {
				return j;
			}
			
			public void hello() {
				System.out.println("hello");
			}
			
			public void increment(int inc) {
				this.i = this.i + inc;
			}
			
			public boolean testString(String tested) {
				return this.s == tested;
			}
			
			public int getI() {
				return this.i;
			}
		}
		
		abstract class Y extends X {
			
			public abstract void ymethod();
			
			// Override
			public int identity(int j) {
				return j+1;
			}
		}
		
		class Z extends Y {
			
			public void ymethod() {
				System.out.println("ymethod");
			}
		}
		
		class Main  {
			public static void main(String[] args) {
				«mainContent»
			} 
		}'''
	}

	public def static void assertPrint(State state, String... expecteds) {
		val stream = state.outputStream.stream
		Assert::assertEquals(stream.size, expecteds.size)
		var int index = 0
		for (expected : expecteds) {
			val s = stream.get(index)
			Assert::assertEquals("List of printed strings should be of same size.", expected, s)
			index++
		}
	}

	public def static Value get(Context context, String symbol) {
		val result = context.bindings.findFirst[it.symbol.name == symbol]
		if (result !== null) {
			return result.value
		} else if (context.parentContext !== null) {
			return context.parentContext.get(symbol)
		} else {
			return null;
		}
	}

	public def static Set<SymbolBinding> getAllSymbolBindings(Context context) {
		if (context.childContext !== null) {
			return (context.bindings + context.childContext.allSymbolBindings).toSet
		} else {
			return context.bindings.toSet
		}
	}

	public static val factory = MiniJavaFactory::eINSTANCE

	public def void genericTest(String program, EList<String> args, Consumer<State> oracle) {
		EPackage.Registry.INSTANCE.put(MiniJavaPackage.eNS_URI, MiniJavaPackage.eINSTANCE)
		val helper = new ValidationTestHelper();
		val Program result = parseHelper.parse(program)
		Assert.assertNotNull(result)
		helper.assertNoErrors(result)
		val op = result.accept(visitor) as ProgramOperationImpl
		op.initialize(args)
		val state = op.execute
		oracle.accept(state)
	}

	public def void genericPrintTest(String program, String... expected) {
		genericTest(program, new BasicEList , [State s|Assert::assertEquals(expected.toList, s.outputStream.stream)])
	}

	public def void genericExpressionTest(EList<String> args, String preStatements,  String type, String expression, Object expectedValue) {
		val program = prepareTestProgram('''  «preStatements» «type» x = «expression»; ''')
		genericTest(program, args, [ s |
			val result = s.contextCache.get("x")
			Assert::assertTrue('''«expectedValue» is different from «result»''', MiniJavaValueEquals::equals(
				result,
				expectedValue
			))
		])
	}
	
	public def void genericExpressionTest(String preStatements,  String type, String expression, Object expectedValue) {
		genericExpressionTest(new BasicEList,preStatements,type,expression,expectedValue)
	}

	public def void genericExpressionTest(String type, String expression, Object expectedValue) {
		genericExpressionTest("", type, expression, expectedValue)
	}
	
	public def void genericExpressionTest(EList<String> args, String type, String expression, Object expectedValue) {
		genericExpressionTest(args, "", type, expression, expectedValue)
	}

	public def void genericStatementTest(String statement, Consumer<State> oracle) {
		val program = prepareTestProgram(statement)
		genericTest(program, new BasicEList, oracle)
	}

	public def void genericStatementPrintTest(String statement, String... expected) {
		genericStatementTest(statement, [State s|Assert::assertEquals(expected.toList, s.outputStream.stream)])
	}

	public def void genericStatementBindingsTest(String statement, Map<String, Object> expectedBindings) {
		genericStatementTest(statement, [ State s |
			Assert::assertEquals(expectedBindings.size,
				s.frameCache.rootContext.childContext.allSymbolBindings.size)
			for (symbol : expectedBindings.keySet) {
				val expectedValue = expectedBindings.get(symbol)
				val value = s.contextCache.get(symbol)
				Assert::assertTrue(MiniJavaValueEquals::equals(value, expectedValue))
			}
		])
	}

}
