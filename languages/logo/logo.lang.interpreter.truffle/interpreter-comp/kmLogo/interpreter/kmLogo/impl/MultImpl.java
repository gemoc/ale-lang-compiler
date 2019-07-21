package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Mult"
)
public class MultImpl extends BinaryExpImpl {
	protected MultImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.MULT;
	}

	public double eval(TurtleImpl turtle) {
		double result;
		result = (double) ((((ExpressionImpl) (this.lhs)).eval((TurtleImpl) (turtle))) * (((ExpressionImpl) (this.rhs)).eval((TurtleImpl) (turtle)))) ;
		return result;
	}
}
