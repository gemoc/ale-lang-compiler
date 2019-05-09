package testmaprelations.visitor.testmaprelations.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testmaprelations.visitor.testmaprelations.CB7;
import testmaprelations.visitor.testmaprelations.TestmaprelationsPackage;
import visitor.VisitorInterface;

public class CB7Impl extends MinimalEObjectImpl.Container implements CB7 {
	protected CB7Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.CB7;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestmaprelations__CB7(this);
	}
}
