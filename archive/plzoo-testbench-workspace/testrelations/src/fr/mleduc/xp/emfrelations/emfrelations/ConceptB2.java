/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept B2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB2#getConcepta2 <em>Concepta2</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB2()
 * @model
 * @generated
 */
public interface ConceptB2 extends EObject {
	/**
	 * Returns the value of the '<em><b>Concepta2</b></em>' reference list.
	 * The list contents are of type {@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA2}.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA2#getConceptb2 <em>Conceptb2</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concepta2</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concepta2</em>' reference list.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptB2_Concepta2()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptA2#getConceptb2
	 * @model opposite="conceptb2"
	 * @generated
	 */
	EList<ConceptA2> getConcepta2();

} // ConceptB2
