package declarationorder.interpreter.declarationorder.impl;

import declarationorder.interpreter.declarationorder.Child;
import declarationorder.interpreter.declarationorder.DeclarationorderPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class ChildImpl extends SImpl implements Child {
	protected ChildImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return DeclarationorderPackage.Literals.CHILD;
	}
}
