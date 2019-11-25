package testoperationbody.visitor.testoperationbody.impl;

import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testoperationbody.visitor.testoperationbody.Parent;
import testoperationbody.visitor.testoperationbody.TestoperationbodyPackage;

public abstract class ParentImpl extends MinimalEObjectImpl.Container implements Parent {
	protected ParentImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.PARENT;
	}
}
