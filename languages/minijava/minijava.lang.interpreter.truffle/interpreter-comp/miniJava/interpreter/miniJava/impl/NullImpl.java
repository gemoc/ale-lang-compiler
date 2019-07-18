package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Null"
)
public class NullImpl extends ExpressionImpl {
	protected NullImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.NULL;
	}

	public ValueImpl evaluateExpression(StateImpl state) {
		ValueImpl result;
		result = (ValueImpl) (MiniJavaFactory.eINSTANCE.createNullValue()) ;
		return result;
	}
}
