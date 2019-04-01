package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.PenUp;
import kmLogo.interpreter.kmLogo.Turtle;
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
		result = 0.0;
		return result;
	}
}
