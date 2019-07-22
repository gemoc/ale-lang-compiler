package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

@NodeInfo(
		description = "Cos"
)
public class CosImpl extends UnaryExpressionImpl {
	protected CosImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.COS;
	}

	public double eval(TurtleImpl turtle) {
		double result;
		result = (double) (TrigoServices.cosinus((double) (((ExpressionImpl) (this.expression)).eval((TurtleImpl) (turtle))))) ;
		return result;
	}
}
