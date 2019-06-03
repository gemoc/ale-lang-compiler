package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Tan;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class TanImpl extends UnaryExpressionImpl implements Tan {
	protected TanImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.TAN;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (TrigoServices.tan((double) (((Expression) (this.expression)).eval((Turtle) (turtle))))) ;
		return result;
	}
}
