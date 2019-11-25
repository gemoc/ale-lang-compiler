package testmaprelations.visitor.testmaprelations.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testmaprelations.visitor.testmaprelations.CA7;
import testmaprelations.visitor.testmaprelations.TestmaprelationsPackage;
import visitor.VisitorInterface;

public class CA7Impl extends MinimalEObjectImpl.Container implements CA7 {
	protected CA7Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CA7;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestmaprelations__CA7(this);
	}
}
