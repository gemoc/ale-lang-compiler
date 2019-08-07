package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.This;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "This"
)
public class ThisImpl extends ExpressionImpl implements This {
	protected ThisImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.THIS;
	}

	public Value evaluateExpression(State state) {
		Value result;
		ObjectInstance currentInstance = ((ObjectInstance) (((State) (state)).findCurrentFrame().getInstance()));
		ObjectRefValue tmp = ((ObjectRefValue) (MiniJavaFactory.eINSTANCE.createObjectRefValue()));
		tmp.setInstance(currentInstance);
		result = (Value) (tmp) ;
		return result;
	}
}
