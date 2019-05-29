package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Expression;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Mult;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
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
