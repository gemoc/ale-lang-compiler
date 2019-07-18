package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

@NodeInfo(
		description = "Tan"
)
public class TanImpl extends UnaryExpressionImpl {
	protected TanImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.TAN;
	}

	public double eval(TurtleImpl turtle) {
		double result;
		result = (double) (TrigoServices.tan((double) (((ExpressionImpl) (this.expression)).eval((TurtleImpl) (turtle))))) ;
		return result;
	}
}
