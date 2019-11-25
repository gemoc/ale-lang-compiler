/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.util;

import fr.mleduc.xp.emfrelations.emfrelations.*;

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
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage
 * @generated
 */
public class EmfrelationsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EmfrelationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfrelationsSwitch() {
		if (modelPackage == null) {
			modelPackage = EmfrelationsPackage.eINSTANCE;
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
			case EmfrelationsPackage.CONCEPT_A0: {
				ConceptA0 conceptA0 = (ConceptA0)theEObject;
				T result = caseConceptA0(conceptA0);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B0: {
				ConceptB0 conceptB0 = (ConceptB0)theEObject;
				T result = caseConceptB0(conceptB0);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_A1: {
				ConceptA1 conceptA1 = (ConceptA1)theEObject;
				T result = caseConceptA1(conceptA1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B1: {
				ConceptB1 conceptB1 = (ConceptB1)theEObject;
				T result = caseConceptB1(conceptB1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_A2: {
				ConceptA2 conceptA2 = (ConceptA2)theEObject;
				T result = caseConceptA2(conceptA2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B2: {
				ConceptB2 conceptB2 = (ConceptB2)theEObject;
				T result = caseConceptB2(conceptB2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_A3: {
				ConceptA3 conceptA3 = (ConceptA3)theEObject;
				T result = caseConceptA3(conceptA3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B3: {
				ConceptB3 conceptB3 = (ConceptB3)theEObject;
				T result = caseConceptB3(conceptB3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_A4: {
				ConceptA4 conceptA4 = (ConceptA4)theEObject;
				T result = caseConceptA4(conceptA4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B4: {
				ConceptB4 conceptB4 = (ConceptB4)theEObject;
				T result = caseConceptB4(conceptB4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_A5: {
				ConceptA5 conceptA5 = (ConceptA5)theEObject;
				T result = caseConceptA5(conceptA5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B5: {
				ConceptB5 conceptB5 = (ConceptB5)theEObject;
				T result = caseConceptB5(conceptB5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_A8: {
				ConceptA8 conceptA8 = (ConceptA8)theEObject;
				T result = caseConceptA8(conceptA8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B8: {
				ConceptB8 conceptB8 = (ConceptB8)theEObject;
				T result = caseConceptB8(conceptB8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_A9: {
				ConceptA9 conceptA9 = (ConceptA9)theEObject;
				T result = caseConceptA9(conceptA9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B9: {
				ConceptB9 conceptB9 = (ConceptB9)theEObject;
				T result = caseConceptB9(conceptB9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_A10: {
				ConceptA10 conceptA10 = (ConceptA10)theEObject;
				T result = caseConceptA10(conceptA10);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B10: {
				ConceptB10 conceptB10 = (ConceptB10)theEObject;
				T result = caseConceptB10(conceptB10);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_A11: {
				ConceptA11 conceptA11 = (ConceptA11)theEObject;
				T result = caseConceptA11(conceptA11);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfrelationsPackage.CONCEPT_B11: {
				ConceptB11 conceptB11 = (ConceptB11)theEObject;
				T result = caseConceptB11(conceptB11);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A0</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A0</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA0(ConceptA0 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B0</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B0</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB0(ConceptB0 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA1(ConceptA1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB1(ConceptB1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA2(ConceptA2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB2(ConceptB2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA3(ConceptA3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB3(ConceptB3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA4(ConceptA4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB4(ConceptB4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A5</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A5</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA5(ConceptA5 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B5</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B5</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB5(ConceptB5 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A8</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A8</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA8(ConceptA8 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B8</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B8</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB8(ConceptB8 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A9</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A9</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA9(ConceptA9 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B9</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B9</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB9(ConceptB9 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A10</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A10</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA10(ConceptA10 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B10</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B10</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB10(ConceptB10 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A11</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A11</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA11(ConceptA11 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B11</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B11</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB11(ConceptB11 object) {
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

} //EmfrelationsSwitch
