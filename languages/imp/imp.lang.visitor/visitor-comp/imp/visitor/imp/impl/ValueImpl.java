package imp.visitor.imp.impl;

import imp.visitor.imp.ImpPackage;
import imp.visitor.imp.Value;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public abstract class ValueImpl extends MinimalEObjectImpl.Container implements Value {
	protected ValueImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.VALUE;
	}
}
