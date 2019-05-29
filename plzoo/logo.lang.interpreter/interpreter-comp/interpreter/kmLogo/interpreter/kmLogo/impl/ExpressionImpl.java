package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Expression;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public abstract class ExpressionImpl extends InstructionImpl implements Expression {
	protected ExpressionImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.EXPRESSION;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (0.0) ;
		return result;
	}
}
