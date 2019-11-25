/**
 */
package test1;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test1.ConceptA#getCs <em>Cs</em>}</li>
 * </ul>
 *
 * @see test1.Test1Package#getConceptA()
 * @model
 * @generated
 */
public interface ConceptA extends EObject {
	/**
	 * Returns the value of the '<em><b>Cs</b></em>' containment reference list.
	 * The list contents are of type {@link test1.ConceptC}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cs</em>' containment reference list.
	 * @see test1.Test1Package#getConceptA_Cs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConceptC> getCs();

} // ConceptA
