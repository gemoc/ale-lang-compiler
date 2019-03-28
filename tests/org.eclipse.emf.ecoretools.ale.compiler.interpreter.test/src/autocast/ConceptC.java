/**
 */
package autocast;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept C</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link autocast.ConceptC#getAx <em>Ax</em>}</li>
 * </ul>
 *
 * @see autocast.AutocastPackage#getConceptC()
 * @model
 * @generated
 */
public interface ConceptC extends EObject {
	/**
	 * Returns the value of the '<em><b>Ax</b></em>' containment reference list.
	 * The list contents are of type {@link autocast.ConceptA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ax</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ax</em>' containment reference list.
	 * @see autocast.AutocastPackage#getConceptC_Ax()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConceptA> getAx();

} // ConceptC
