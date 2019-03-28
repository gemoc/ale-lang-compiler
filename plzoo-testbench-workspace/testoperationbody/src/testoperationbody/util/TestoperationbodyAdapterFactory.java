
package testoperationbody.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import testoperationbody.*;


public class TestoperationbodyAdapterFactory extends AdapterFactoryImpl {
	
	protected static TestoperationbodyPackage modelPackage;

	
	public TestoperationbodyAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TestoperationbodyPackage.eINSTANCE;
		}
	}

	
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	
	protected TestoperationbodySwitch<Adapter> modelSwitch =
		new TestoperationbodySwitch<Adapter>() {
			@Override
			public Adapter caseMain(Main object) {
				return createMainAdapter();
			}
			@Override
			public Adapter caseConceptA(ConceptA object) {
				return createConceptAAdapter();
			}
			@Override
			public Adapter caseParent(Parent object) {
				return createParentAdapter();
			}
			@Override
			public Adapter caseChildA(ChildA object) {
				return createChildAAdapter();
			}
			@Override
			public Adapter caseChildB(ChildB object) {
				return createChildBAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	
	public Adapter createMainAdapter() {
		return null;
	}

	
	public Adapter createConceptAAdapter() {
		return null;
	}

	
	public Adapter createParentAdapter() {
		return null;
	}

	
	public Adapter createChildAAdapter() {
		return null;
	}

	
	public Adapter createChildBAdapter() {
		return null;
	}

	
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TestoperationbodyAdapterFactory
