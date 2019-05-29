package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Clear;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class ClearImpl extends PrimitiveImpl implements Clear {
	protected ClearImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.CLEAR;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (0.0) ;
		return result;
	}
}
