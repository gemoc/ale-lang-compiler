/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept B0</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB0#getConcepta0 <em>Concepta0</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB0()
 * @model
 * @generated
 */
public interface ConceptB0 extends EObject {
	/**
	 * Returns the value of the '<em><b>Concepta0</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA0#getConceptb0 <em>Conceptb0</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concepta0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concepta0</em>' reference.
	 * @see #setConcepta0(ConceptA0)
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB0_Concepta0()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA0#getConceptb0
	 * @model opposite="conceptb0"
	 * @generated
	 */
	ConceptA0 getConcepta0();

	/**
	 * Sets the value of the '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB0#getConcepta0 <em>Concepta0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concepta0</em>' reference.
	 * @see #getConcepta0()
	 * @generated
	 */
	void setConcepta0(ConceptA0 value);

} // ConceptB0
