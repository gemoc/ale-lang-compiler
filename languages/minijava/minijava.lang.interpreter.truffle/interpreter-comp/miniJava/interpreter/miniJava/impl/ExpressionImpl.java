package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Expression"
)
public class ExpressionImpl extends StatementImpl {
	protected ExpressionImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.EXPRESSION;
	}

	public void evaluateStatement(StateImpl state) {
		((ExpressionImpl) (this)).evaluateExpression((StateImpl) (state));
	}

	public ValueImpl evaluateExpression(StateImpl state) {
		ValueImpl result;
		result = (ValueImpl) (null) ;
		return result;
	}
}
