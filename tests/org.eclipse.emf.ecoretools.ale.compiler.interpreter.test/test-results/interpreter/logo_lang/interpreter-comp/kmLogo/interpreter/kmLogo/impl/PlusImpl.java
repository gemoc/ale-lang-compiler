package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Plus;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

public class PlusImpl extends BinaryExpImpl implements Plus {
	protected PlusImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PLUS;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (((Expression) this.lhs).eval((Turtle) (turtle))) + (((Expression) this.rhs).eval((Turtle) (turtle)));
		return result;
	}
}
