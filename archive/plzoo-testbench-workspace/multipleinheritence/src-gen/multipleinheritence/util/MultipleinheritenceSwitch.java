/**
 */
package multipleinheritence.util;

import multipleinheritence.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see multipleinheritence.MultipleinheritencePackage
 * @generated
 */
public class MultipleinheritenceSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MultipleinheritencePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleinheritenceSwitch() {
		if (modelPackage == null) {
			modelPackage = MultipleinheritencePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case MultipleinheritencePackage.NEW_ECLASS1: {
			NewEClass1 newEClass1 = (NewEClass1) theEObject;
			T result = caseNewEClass1(newEClass1);
			if (result == null)
				result = caseNewEClass2(newEClass1);
			if (result == null)
				result = caseNewEClass3(newEClass1);
			if (result == null)
				result = caseNewEClass4(newEClass1);
			if (result == null)
				result = caseNewEClass5(newEClass1);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MultipleinheritencePackage.NEW_ECLASS2: {
			NewEClass2 newEClass2 = (NewEClass2) theEObject;
			T result = caseNewEClass2(newEClass2);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MultipleinheritencePackage.NEW_ECLASS3: {
			NewEClass3 newEClass3 = (NewEClass3) theEObject;
			T result = caseNewEClass3(newEClass3);
			if (result == null)
				result = caseNewEClass4(newEClass3);
			if (result == null)
				result = caseNewEClass5(newEClass3);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MultipleinheritencePackage.NEW_ECLASS4: {
			NewEClass4 newEClass4 = (NewEClass4) theEObject;
			T result = caseNewEClass4(newEClass4);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MultipleinheritencePackage.NEW_ECLASS5: {
			NewEClass5 newEClass5 = (NewEClass5) theEObject;
			T result = caseNewEClass5(newEClass5);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New EClass1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New EClass1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewEClass1(NewEClass1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New EClass2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New EClass2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewEClass2(NewEClass2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New EClass3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New EClass3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewEClass3(NewEClass3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New EClass4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New EClass4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewEClass4(NewEClass4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New EClass5</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New EClass5</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewEClass5(NewEClass5 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MultipleinheritenceSwitch
