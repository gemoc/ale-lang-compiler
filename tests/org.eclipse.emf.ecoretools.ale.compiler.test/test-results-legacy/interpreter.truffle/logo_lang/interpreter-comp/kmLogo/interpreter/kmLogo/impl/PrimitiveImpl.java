package kmLogo.interpreter.kmLogo.impl;

import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Primitive;
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
