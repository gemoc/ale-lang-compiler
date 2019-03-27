/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept A1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA1#getConceptb1 <em>Conceptb1</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA1()
 * @model
 * @generated
 */
public interface ConceptA1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptb1</b></em>' reference list.
	 * The list contents are of type {@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB1}.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB1#getConcepta1 <em>Concepta1</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptb1</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptb1</em>' reference list.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA1_Conceptb1()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB1#getConcepta1
	 * @model opposite="concepta1"
	 * @generated
	 */
	EList<ConceptB1> getConceptb1();

} // ConceptA1
