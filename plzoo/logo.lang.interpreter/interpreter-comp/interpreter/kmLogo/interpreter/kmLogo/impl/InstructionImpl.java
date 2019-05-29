package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.Instruction;
import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Turtle;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public abstract class InstructionImpl extends MinimalEObjectImpl.Container implements Instruction {
	protected InstructionImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.INSTRUCTION;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (0.0) ;
		return result;
	}
}
