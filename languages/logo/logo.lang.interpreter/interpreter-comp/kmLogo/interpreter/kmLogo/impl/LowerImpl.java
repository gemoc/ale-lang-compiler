package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Lower;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

public class LowerImpl extends BinaryExpImpl implements Lower {
	protected LowerImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.LOWER;
	}

	public double eval(Turtle turtle) {
		double result;
		if ((((Expression) (this.lhs)).eval((Turtle) (turtle))) < (((Expression) (this.rhs)).eval((Turtle) (turtle)))) {
			result = (double) (1.0) ;
		}
		else {
			result = (double) (0.0) ;
		}
		return result;
	}
}
