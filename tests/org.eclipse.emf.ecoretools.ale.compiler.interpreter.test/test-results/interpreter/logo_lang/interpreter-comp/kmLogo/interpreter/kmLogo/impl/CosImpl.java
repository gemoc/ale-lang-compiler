package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.Cos;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

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
		result = org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.cosinus((double)((kmLogo.interpreter.kmLogo.Expression) this.expression).eval((kmLogo.interpreter.kmLogo.Turtle) (turtle)));
		return result;
	}
}
