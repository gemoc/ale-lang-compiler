/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept A2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA2#getConceptb2 <em>Conceptb2</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA2()
 * @model
 * @generated
 */
public interface ConceptA2 extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptb2</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB2#getConcepta2 <em>Concepta2</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptb2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptb2</em>' reference.
	 * @see #setConceptb2(ConceptB2)
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA2_Conceptb2()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB2#getConcepta2
	 * @model opposite="concepta2"
	 * @generated
	 */
	ConceptB2 getConceptb2();

	/**
	 * Sets the value of the '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA2#getConceptb2 <em>Conceptb2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conceptb2</em>' reference.
	 * @see #getConceptb2()
	 * @generated
	 */
	void setConceptb2(ConceptB2 value);

} // ConceptA2
