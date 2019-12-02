package factorydeclorder.interpreter.factorydeclorder.impl;

import factorydeclorder.interpreter.factorydeclorder.D;
import factorydeclorder.interpreter.factorydeclorder.FactorydeclorderPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class DImpl extends MinimalEObjectImpl.Container implements D {
	protected DImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FactorydeclorderPackage.Literals.D;
	}
}
