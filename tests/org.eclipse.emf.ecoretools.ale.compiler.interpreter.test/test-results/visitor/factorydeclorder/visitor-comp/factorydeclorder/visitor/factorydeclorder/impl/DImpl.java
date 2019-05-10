package factorydeclorder.visitor.factorydeclorder.impl;

import factorydeclorder.visitor.factorydeclorder.D;
import factorydeclorder.visitor.factorydeclorder.FactorydeclorderPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class DImpl extends MinimalEObjectImpl.Container implements D {
	protected DImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FactorydeclorderPackage.Literals.D;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitfactorydeclorder__D(this);
	}
}
