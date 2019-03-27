/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept B1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB1#getConcepta1 <em>Concepta1</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB1()
 * @model
 * @generated
 */
public interface ConceptB1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Concepta1</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA1#getConceptb1 <em>Conceptb1</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concepta1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concepta1</em>' reference.
	 * @see #setConcepta1(ConceptA1)
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB1_Concepta1()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA1#getConceptb1
	 * @model opposite="conceptb1"
	 * @generated
	 */
	ConceptA1 getConcepta1();

	/**
	 * Sets the value of the '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB1#getConcepta1 <em>Concepta1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concepta1</em>' reference.
	 * @see #getConcepta1()
	 * @generated
	 */
	void setConcepta1(ConceptA1 value);

} // ConceptB1
