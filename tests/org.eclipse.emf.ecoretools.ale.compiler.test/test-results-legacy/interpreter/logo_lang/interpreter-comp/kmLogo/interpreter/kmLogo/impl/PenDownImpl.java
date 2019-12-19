package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.PenDown;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

public class PenDownImpl extends PrimitiveImpl implements PenDown {
	protected PenDownImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PEN_DOWN;
	}

	public double eval(Turtle turtle) {
		double result;
		turtle.setPenUp(false);
		result = (double) (0.0) ;
		return result;
	}
}
