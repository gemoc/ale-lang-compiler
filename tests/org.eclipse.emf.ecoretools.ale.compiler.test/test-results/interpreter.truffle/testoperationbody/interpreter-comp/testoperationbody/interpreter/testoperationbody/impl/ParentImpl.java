package testoperationbody.interpreter.testoperationbody.impl;

import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testoperationbody.interpreter.testoperationbody.Parent;
import testoperationbody.interpreter.testoperationbody.TestoperationbodyPackage;

public abstract class ParentImpl extends MinimalEObjectImpl.Container implements Parent {
	protected ParentImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.PARENT;
	}

	public void notOverriden() {
	}

	public void overriden() {
	}
}
