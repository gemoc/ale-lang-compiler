package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Null;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Null"
)
public class NullImpl extends ExpressionImpl implements Null {
	protected NullImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.NULL;
	}

	public Value evaluateExpression(State state) {
		Value result;
		result = (Value) (MiniJavaFactory.eINSTANCE.createNullValue()) ;
		return result;
	}
}
