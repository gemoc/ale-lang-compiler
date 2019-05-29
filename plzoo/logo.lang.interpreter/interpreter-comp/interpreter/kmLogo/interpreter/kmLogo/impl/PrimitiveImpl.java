package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Primitive;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public abstract class PrimitiveImpl extends InstructionImpl implements Primitive {
	protected PrimitiveImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PRIMITIVE;
	}
}
