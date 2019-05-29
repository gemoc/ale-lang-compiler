package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Expression;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Tan;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
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
