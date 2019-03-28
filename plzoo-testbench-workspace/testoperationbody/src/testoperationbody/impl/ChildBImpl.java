
package testoperationbody.impl;

import org.eclipse.emf.ecore.EClass;

import testoperationbody.ChildB;
import testoperationbody.TestoperationbodyPackage;


public class ChildBImpl extends ParentImpl implements ChildB {
	
	protected ChildBImpl() {
		super();
	}

	
	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.CHILD_B;
	}

} //ChildBImpl
