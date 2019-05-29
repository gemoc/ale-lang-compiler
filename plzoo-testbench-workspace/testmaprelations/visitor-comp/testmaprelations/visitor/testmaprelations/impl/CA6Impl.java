package testmaprelations.visitor.testmaprelations.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testmaprelations.visitor.testmaprelations.CA6;
import testmaprelations.visitor.testmaprelations.TestmaprelationsPackage;
import visitor.VisitorInterface;

public class CA6Impl extends MinimalEObjectImpl.Container implements CA6 {
	protected CA6Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CA6;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestmaprelations__CA6(this);
	}
}
