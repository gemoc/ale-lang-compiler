package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Expression;
import interpreter.kmLogo.interpreter.kmLogo.Greater;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
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
		if ((((Expression) (this.lhs)).eval((Turtle) (turtle))) > (((Expression) (this.rhs)).eval((Turtle) (turtle)))) {
			result = (double) (1.0) ;
		}
		else {
			result = (double) (0.0) ;
		}
		return result;
	}
}
