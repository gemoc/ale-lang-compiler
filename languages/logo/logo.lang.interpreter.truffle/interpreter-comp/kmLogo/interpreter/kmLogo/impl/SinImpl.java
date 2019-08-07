package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Sin;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

@NodeInfo(
		description = "Sin"
)
public class SinImpl extends UnaryExpressionImpl implements Sin {
	protected SinImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.SIN;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (TrigoServices.sinus((double) (((Expression) (this.expression)).eval((Turtle) (turtle))))) ;
		return result;
	}
}
