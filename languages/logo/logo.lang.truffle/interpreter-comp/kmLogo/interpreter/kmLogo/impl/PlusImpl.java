package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Plus"
)
public class PlusImpl extends BinaryExpImpl {
	protected PlusImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PLUS;
	}

	public double eval(TurtleImpl turtle) {
		double result;
		result = (double) ((((ExpressionImpl) (this.lhs)).eval((TurtleImpl) (turtle))) + (((ExpressionImpl) (this.rhs)).eval((TurtleImpl) (turtle)))) ;
		return result;
	}
}
