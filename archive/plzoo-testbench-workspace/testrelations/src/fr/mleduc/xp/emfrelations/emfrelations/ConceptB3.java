/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept B3</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB3#getConcepta3 <em>Concepta3</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB3()
 * @model
 * @generated
 */
public interface ConceptB3 extends EObject {
	/**
	 * Returns the value of the '<em><b>Concepta3</b></em>' reference list.
	 * The list contents are of type {@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA3}.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA3#getConceptb3 <em>Conceptb3</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concepta3</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concepta3</em>' reference list.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB3_Concepta3()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA3#getConceptb3
	 * @model opposite="conceptb3"
	 * @generated
	 */
	EList<ConceptA3> getConcepta3();

} // ConceptB3
