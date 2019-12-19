package testoperationbody.interpreter.testoperationbody.impl;

import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import testoperationbody.interpreter.testoperationbody.ChildB;
import testoperationbody.interpreter.testoperationbody.TestoperationbodyPackage;

public class ChildBImpl extends ParentImpl implements ChildB {
	protected ChildBImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.CHILD_B;
	}

	public void overriden() {
	}
}
