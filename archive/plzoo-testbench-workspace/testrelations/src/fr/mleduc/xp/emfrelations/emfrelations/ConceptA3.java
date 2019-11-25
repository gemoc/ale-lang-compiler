/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept A3</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA3#getConceptb3 <em>Conceptb3</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA3()
 * @model
 * @generated
 */
public interface ConceptA3 extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptb3</b></em>' reference list.
	 * The list contents are of type {@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB3}.
	 * It is bidirectional and its opposite is '{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB3#getConcepta3 <em>Concepta3</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptb3</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptb3</em>' reference list.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA3_Conceptb3()
	 * @see fr.mleduc.xp.emfrelations.emfrelations.ConceptB3#getConcepta3
	 * @model opposite="concepta3"
	 * @generated
	 */
	EList<ConceptB3> getConceptb3();

} // ConceptA3
