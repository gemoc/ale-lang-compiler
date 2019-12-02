package kmLogo.visitor.kmLogo.impl;

import java.lang.Override;
import kmLogo.visitor.kmLogo.Instruction;
import kmLogo.visitor.kmLogo.KmLogoPackage;
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
}
