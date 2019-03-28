
package testoperationbody.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import testoperationbody.Parent;
import testoperationbody.TestoperationbodyPackage;


public abstract class ParentImpl extends MinimalEObjectImpl.Container implements Parent {
	
	protected ParentImpl() {
		super();
	}

	
	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.PARENT;
	}

} //ParentImpl
