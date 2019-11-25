
package emapvselistentry.util;

import emapvselistentry.*;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;


public class EmapvselistentrySwitch<T> extends Switch<T> {
	
	protected static EmapvselistentryPackage modelPackage;

	
	public EmapvselistentrySwitch() {
		if (modelPackage == null) {
			modelPackage = EmapvselistentryPackage.eINSTANCE;
		}
	}

	
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EmapvselistentryPackage.NEW_ECLASS1: {
				NewEClass1 newEClass1 = (NewEClass1)theEObject;
				T result = caseNewEClass1(newEClass1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmapvselistentryPackage.NEW_ECLASS2: {
				@SuppressWarnings("unchecked") Map.Entry<Integer, Boolean> newEClass2 = (Map.Entry<Integer, Boolean>)theEObject;
				T result = caseNewEClass2(newEClass2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmapvselistentryPackage.NEW_ECLASS3: {
				@SuppressWarnings("unchecked") Map.Entry<Integer, Boolean> newEClass3 = (Map.Entry<Integer, Boolean>)theEObject;
				T result = caseNewEClass3(newEClass3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmapvselistentryPackage.NEW_ECLASS4: {
				@SuppressWarnings("unchecked") Map.Entry<Integer, Boolean> newEClass4 = (Map.Entry<Integer, Boolean>)theEObject;
				T result = caseNewEClass4(newEClass4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmapvselistentryPackage.NEW_ECLASS5: {
				@SuppressWarnings("unchecked") Map.Entry<Integer, Boolean> newEClass5 = (Map.Entry<Integer, Boolean>)theEObject;
				T result = caseNewEClass5(newEClass5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	
	public T caseNewEClass1(NewEClass1 object) {
		return null;
	}

	
	public T caseNewEClass2(Map.Entry<Integer, Boolean> object) {
		return null;
	}

	
	public T caseNewEClass3(Map.Entry<Integer, Boolean> object) {
		return null;
	}

	
	public T caseNewEClass4(Map.Entry<Integer, Boolean> object) {
		return null;
	}

	
	public T caseNewEClass5(Map.Entry<Integer, Boolean> object) {
		return null;
	}

	
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EmapvselistentrySwitch
