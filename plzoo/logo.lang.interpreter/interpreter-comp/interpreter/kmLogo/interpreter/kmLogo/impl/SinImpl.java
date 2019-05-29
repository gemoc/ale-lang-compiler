package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Expression;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Sin;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class SinImpl extends UnaryExpressionImpl implements Sin {
	protected SinImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.SIN;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (TrigoServices.sinus((double) (((Expression) (this.expression)).eval((Turtle) (turtle))))) ;
		return result;
	}
}
