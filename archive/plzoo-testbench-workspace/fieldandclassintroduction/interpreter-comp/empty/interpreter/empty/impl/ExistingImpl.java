package empty.interpreter.empty.impl;

import empty.interpreter.empty.EmptyPackage;
import empty.interpreter.empty.Existing;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class ExistingImpl extends MinimalEObjectImpl.Container implements Existing {
	protected ExistingImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmptyPackage.Literals.EXISTING;
	}

}