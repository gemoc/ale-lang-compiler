package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "BoolOp"
)
public abstract class BoolOpImpl extends ExprImpl {
	protected BoolOpImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.BOOL_OP;
	}
}
