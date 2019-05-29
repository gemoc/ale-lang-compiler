package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.PenUp;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class PenUpImpl extends PrimitiveImpl implements PenUp {
	protected PenUpImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PEN_UP;
	}

	public double eval(Turtle turtle) {
		double result;
		turtle.setPenUp(true);
		result = (double) (0.0) ;
		return result;
	}
}
