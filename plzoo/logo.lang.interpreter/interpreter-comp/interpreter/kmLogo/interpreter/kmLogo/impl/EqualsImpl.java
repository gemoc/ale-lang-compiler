package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Equals;
import interpreter.kmLogo.interpreter.kmLogo.Expression;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class EqualsImpl extends BinaryExpImpl implements Equals {
	protected EqualsImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.EQUALS;
	}

	public double eval(Turtle turtle) {
		double result;
		if (EqualService.equals((((Expression) (this.lhs)).eval((Turtle) (turtle))), (((Expression) (this.rhs)).eval((Turtle) (turtle))))) {
			result = (double) (1.0) ;
		}
		else {
			result = (double) (0.0) ;
		}
		return result;
	}
}
