/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept B4</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB4#getConcepta4 <em>Concepta4</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB4()
 * @model
 * @generated
 */
public interface ConceptB4 extends EObject {
	/**
	 * Returns the value of the '<em><b>Concepta4</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA4#getConceptb4 <em>Conceptb4</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concepta4</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concepta4</em>' container reference.
	 * @see #setConcepta4(ConceptA4)
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB4_Concepta4()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA4#getConceptb4
	 * @model opposite="conceptb4" transient="false"
	 * @generated
	 */
	ConceptA4 getConcepta4();

	/**
	 * Sets the value of the '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB4#getConcepta4 <em>Concepta4</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concepta4</em>' container reference.
	 * @see #getConcepta4()
	 * @generated
	 */
	void setConcepta4(ConceptA4 value);

} // ConceptB4
