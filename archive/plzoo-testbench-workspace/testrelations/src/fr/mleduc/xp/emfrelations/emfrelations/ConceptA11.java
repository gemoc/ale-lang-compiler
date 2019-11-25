/**
 */
package fr.mleduc.xp.emfrelations.emfrelations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept A11</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.mleduc.xp.emfrelations.emfrelations.ConceptA11#getConceptb11 <em>Conceptb11</em>}</li>
 * </ul>
 *
 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA11()
 * @model
 * @generated
 */
public interface ConceptA11 extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptb11</b></em>' containment reference list.
	 * The list contents are of type {@link fr.mleduc.xp.emfrelations.emfrelations.ConceptB11}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptb11</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptb11</em>' containment reference list.
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#getConceptA11_Conceptb11()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConceptB11> getConceptb11();

} // ConceptA11
