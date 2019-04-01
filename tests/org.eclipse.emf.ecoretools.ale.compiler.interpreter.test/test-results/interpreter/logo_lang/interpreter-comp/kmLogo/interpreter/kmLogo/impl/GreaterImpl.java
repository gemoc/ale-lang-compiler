package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.Greater;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

public class GreaterImpl extends BinaryExpImpl implements Greater {
	protected GreaterImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.GREATER;
	}

	public double eval(Turtle turtle) {
		double result;
		if ((((Expression) this.lhs).eval((Turtle) (turtle))) > (((Expression) this.rhs).eval((Turtle) (turtle)))) {
			result = 1.0;
		}
		else {
			result = 0.0;
		}
		return result;
	}
}
