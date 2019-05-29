package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.PenDown;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
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
