package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Tan;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

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
		result = org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.tan((double)((kmLogo.interpreter.kmLogo.Expression) this.expression).eval((kmLogo.interpreter.kmLogo.Turtle) (turtle)));
		return result;
	}
}
