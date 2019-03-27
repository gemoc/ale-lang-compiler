/**
 */
package testbidirectionalrelation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import testbidirectionalrelation.*;

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
 * @see testbidirectionalrelation.TestbidirectionalrelationPackage
 * @generated
 */
public class TestbidirectionalrelationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TestbidirectionalrelationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbidirectionalrelationSwitch() {
		if (modelPackage == null) {
			modelPackage = TestbidirectionalrelationPackage.eINSTANCE;
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
			case TestbidirectionalrelationPackage.CONCEPT_A: {
				ConceptA conceptA = (ConceptA)theEObject;
				T result = caseConceptA(conceptA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbidirectionalrelationPackage.CONCEPT_B: {
				ConceptB conceptB = (ConceptB)theEObject;
				T result = caseConceptB(conceptB);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbidirectionalrelationPackage.CONCEPT_C: {
				ConceptC conceptC = (ConceptC)theEObject;
				T result = caseConceptC(conceptC);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbidirectionalrelationPackage.CONCEPT_D: {
				ConceptD conceptD = (ConceptD)theEObject;
				T result = caseConceptD(conceptD);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbidirectionalrelationPackage.CONCEPT_E: {
				ConceptE conceptE = (ConceptE)theEObject;
				T result = caseConceptE(conceptE);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbidirectionalrelationPackage.CONCEPT_F: {
				ConceptF conceptF = (ConceptF)theEObject;
				T result = caseConceptF(conceptF);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestbidirectionalrelationPackage.CONCEPT_G: {
				ConceptG conceptG = (ConceptG)theEObject;
				T result = caseConceptG(conceptG);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept A</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept A</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptA(ConceptA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept B</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept B</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptB(ConceptB object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept C</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept C</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptC(ConceptC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptD(ConceptD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept E</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept E</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptE(ConceptE object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept F</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept F</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptF(ConceptF object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept G</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept G</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptG(ConceptG object) {
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

} //TestbidirectionalrelationSwitch
