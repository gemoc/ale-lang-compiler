/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept A4</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA4#getConceptb4 <em>Conceptb4</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA4()
 * @model
 * @generated
 */
public interface ConceptA4 extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptb4</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB4#getConcepta4 <em>Concepta4</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptb4</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptb4</em>' containment reference.
	 * @see #setConceptb4(ConceptB4)
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA4_Conceptb4()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB4#getConcepta4
	 * @model opposite="concepta4" containment="true"
	 * @generated
	 */
	ConceptB4 getConceptb4();

	/**
	 * Sets the value of the '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA4#getConceptb4 <em>Conceptb4</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conceptb4</em>' containment reference.
	 * @see #getConceptb4()
	 * @generated
	 */
	void setConceptb4(ConceptB4 value);

} // ConceptA4
