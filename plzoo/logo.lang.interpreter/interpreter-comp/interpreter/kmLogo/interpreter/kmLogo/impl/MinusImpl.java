package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Expression;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Minus;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class MinusImpl extends BinaryExpImpl implements Minus {
	protected MinusImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.MINUS;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) ((((Expression) (this.lhs)).eval((Turtle) (turtle))) - (((Expression) (this.rhs)).eval((Turtle) (turtle)))) ;
		return result;
	}
}
