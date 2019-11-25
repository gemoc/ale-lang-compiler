package testmaprelations.visitor.testmaprelations.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testmaprelations.visitor.testmaprelations.CA9;
import testmaprelations.visitor.testmaprelations.TestmaprelationsPackage;
import visitor.VisitorInterface;

public class CA9Impl extends MinimalEObjectImpl.Container implements CA9 {
	protected CA9Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CA9;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestmaprelations__CA9(this);
	}
}
