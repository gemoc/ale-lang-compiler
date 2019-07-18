package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "Div"
)
public class DivImpl extends BinaryExpImpl {
	protected DivImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.DIV;
	}

	public double eval(TurtleImpl turtle) {
		double result;
		if (!EqualService.equals((((ExpressionImpl) (this.rhs)).eval((TurtleImpl) (turtle))), (0.0))) {
			result = (double) ((((ExpressionImpl) (this.lhs)).eval((TurtleImpl) (turtle))) / (((ExpressionImpl) (this.rhs)).eval((TurtleImpl) (turtle)))) ;
		}
		else {
			result = (double) (0.0) ;
		}
		return result;
	}
}
