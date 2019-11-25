package declarationorder.interpreter.declarationorder.impl;

import declarationorder.interpreter.declarationorder.DeclarationorderPackage;
import declarationorder.interpreter.declarationorder.S;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class SImpl extends MinimalEObjectImpl.Container implements S {
	protected SImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return DeclarationorderPackage.Literals.S;
	}
}
