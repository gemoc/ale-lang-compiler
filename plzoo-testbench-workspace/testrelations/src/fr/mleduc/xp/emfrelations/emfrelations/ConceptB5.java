/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept B5</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB5#getConcepta5 <em>Concepta5</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB5()
 * @model
 * @generated
 */
public interface ConceptB5 extends EObject {
	/**
	 * Returns the value of the '<em><b>Concepta5</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA5#getConceptb5 <em>Conceptb5</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concepta5</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concepta5</em>' container reference.
	 * @see #setConcepta5(ConceptA5)
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB5_Concepta5()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA5#getConceptb5
	 * @model opposite="conceptb5" transient="false"
	 * @generated
	 */
	ConceptA5 getConcepta5();

	/**
	 * Sets the value of the '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB5#getConcepta5 <em>Concepta5</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concepta5</em>' container reference.
	 * @see #getConcepta5()
	 * @generated
	 */
	void setConcepta5(ConceptA5 value);

} // ConceptB5
