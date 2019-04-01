package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.Equals;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
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
		if (EqualService.equals((((Expression) this.lhs).eval((Turtle) (turtle))), (((Expression) this.rhs).eval((Turtle) (turtle))))) {
			result = 1.0;
		}
		else {
			result = 0.0;
		}
		return result;
	}
}
