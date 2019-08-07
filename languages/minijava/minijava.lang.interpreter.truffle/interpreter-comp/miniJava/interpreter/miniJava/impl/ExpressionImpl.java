package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Expression"
)
public class ExpressionImpl extends StatementImpl implements Expression {
	protected ExpressionImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.EXPRESSION;
	}

	public void evaluateStatement(State state) {
		((Expression) (this)).evaluateExpression((State) (state));
	}

	public Value evaluateExpression(State state) {
		Value result;
		result = (Value) (null) ;
		return result;
	}
}
