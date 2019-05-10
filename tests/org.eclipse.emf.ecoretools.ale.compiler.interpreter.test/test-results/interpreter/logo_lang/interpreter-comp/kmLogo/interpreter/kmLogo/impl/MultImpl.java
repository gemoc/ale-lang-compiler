package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Mult;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

public class MultImpl extends BinaryExpImpl implements Mult {
	protected MultImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.MULT;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) ((((Expression) (this.lhs)).eval((Turtle) (turtle))) * (((Expression) (this.rhs)).eval((Turtle) (turtle)))) ;
		return result;
	}
}
