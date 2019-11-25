
package testoperationbody.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import testoperationbody.*;


public class TestoperationbodySwitch<T> extends Switch<T> {
	
	protected static TestoperationbodyPackage modelPackage;

	
	public TestoperationbodySwitch() {
		if (modelPackage == null) {
			modelPackage = TestoperationbodyPackage.eINSTANCE;
		}
	}

	
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TestoperationbodyPackage.MAIN: {
				Main main = (Main)theEObject;
				T result = caseMain(main);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestoperationbodyPackage.CONCEPT_A: {
				ConceptA conceptA = (ConceptA)theEObject;
				T result = caseConceptA(conceptA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestoperationbodyPackage.PARENT: {
				Parent parent = (Parent)theEObject;
				T result = caseParent(parent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestoperationbodyPackage.CHILD_A: {
				ChildA childA = (ChildA)theEObject;
				T result = caseChildA(childA);
				if (result == null) result = caseParent(childA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestoperationbodyPackage.CHILD_B: {
				ChildB childB = (ChildB)theEObject;
				T result = caseChildB(childB);
				if (result == null) result = caseParent(childB);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	
	public T caseMain(Main object) {
		return null;
	}

	
	public T caseConceptA(ConceptA object) {
		return null;
	}

	
	public T caseParent(Parent object) {
		return null;
	}

	
	public T caseChildA(ChildA object) {
		return null;
	}

	
	public T caseChildB(ChildB object) {
		return null;
	}

	
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TestoperationbodySwitch
