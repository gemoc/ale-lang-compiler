package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "This"
)
public class ThisImpl extends ExpressionImpl {
	protected ThisImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.THIS;
	}

	public ValueImpl evaluateExpression(StateImpl state) {
		ValueImpl result;
		ObjectInstanceImpl currentInstance = ((ObjectInstanceImpl) (((StateImpl) (state)).findCurrentFrame().getInstance()));
		ObjectRefValueImpl tmp = ((ObjectRefValueImpl) (MiniJavaFactory.eINSTANCE.createObjectRefValue()));
		tmp.setInstance(currentInstance);
		result = (ValueImpl) (tmp) ;
		return result;
	}
}
