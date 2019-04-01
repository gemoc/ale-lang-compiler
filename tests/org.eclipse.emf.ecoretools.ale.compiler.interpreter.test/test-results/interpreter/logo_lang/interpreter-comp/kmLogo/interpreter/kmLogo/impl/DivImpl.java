package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.Div;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class DivImpl extends BinaryExpImpl implements Div {
	protected DivImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.DIV;
	}

	public double eval(Turtle turtle) {
		double result;
		if (!EqualService.equals((((Expression) this.rhs).eval((Turtle) (turtle))), (0.0))) {
			result = (((Expression) this.lhs).eval((Turtle) (turtle))) / (((Expression) this.rhs).eval((Turtle) (turtle)));
		}
		else {
			result = 0.0;
		}
		return result;
	}
}
