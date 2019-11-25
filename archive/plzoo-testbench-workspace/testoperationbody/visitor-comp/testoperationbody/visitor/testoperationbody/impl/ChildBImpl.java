package testoperationbody.visitor.testoperationbody.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import testoperationbody.visitor.testoperationbody.ChildB;
import testoperationbody.visitor.testoperationbody.TestoperationbodyPackage;
import visitor.VisitorInterface;

public class ChildBImpl extends ParentImpl implements ChildB {
	protected ChildBImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.CHILD_B;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestoperationbody__ChildB(this);
	}
}
