/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept A10</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA10#getConceptb10 <em>Conceptb10</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA10()
 * @model
 * @generated
 */
public interface ConceptA10 extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptb10</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptb10</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptb10</em>' containment reference.
	 * @see #setConceptb10(ConceptB10)
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA10_Conceptb10()
	 * @model containment="true"
	 * @generated
	 */
	ConceptB10 getConceptb10();

	/**
	 * Sets the value of the '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA10#getConceptb10 <em>Conceptb10</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conceptb10</em>' containment reference.
	 * @see #getConceptb10()
	 * @generated
	 */
	void setConceptb10(ConceptB10 value);

} // ConceptA10
