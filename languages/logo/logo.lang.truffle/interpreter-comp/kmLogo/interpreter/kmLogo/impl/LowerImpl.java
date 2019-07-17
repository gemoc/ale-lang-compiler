package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Lower"
)
public class LowerImpl extends BinaryExpImpl {
	protected LowerImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.LOWER;
	}

	public double eval(TurtleImpl turtle) {
		double result;
		if ((((ExpressionImpl) (this.lhs)).eval((TurtleImpl) (turtle))) < (((ExpressionImpl) (this.rhs)).eval((TurtleImpl) (turtle)))) {
			result = (double) (1.0) ;
		}
		else {
			result = (double) (0.0) ;
		}
		return result;
	}
}
