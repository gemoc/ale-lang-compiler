package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.Instruction;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
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
