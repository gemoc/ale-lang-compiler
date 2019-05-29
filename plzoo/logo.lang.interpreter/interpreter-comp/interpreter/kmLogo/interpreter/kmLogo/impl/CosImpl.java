package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Cos;
import interpreter.kmLogo.interpreter.kmLogo.Expression;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class CosImpl extends UnaryExpressionImpl implements Cos {
	protected CosImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.COS;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (TrigoServices.cosinus((double) (((Expression) (this.expression)).eval((Turtle) (turtle))))) ;
		return result;
	}
}
