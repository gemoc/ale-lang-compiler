package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Expression"
)
public abstract class ExpressionImpl extends InstructionImpl {
	protected ExpressionImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.EXPRESSION;
	}

	public double eval(TurtleImpl turtle) {
		double result;
		result = (double) (0.0) ;
		return result;
	}
}
