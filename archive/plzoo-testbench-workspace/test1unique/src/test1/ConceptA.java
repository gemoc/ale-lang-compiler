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
 *   <li>{@link test1.ConceptA#getBs <em>Bs</em>}</li>
 * </ul>
 *
 * @see test1.Test1uniquePackage#getConceptA()
 * @model
 * @generated
 */
public interface ConceptA extends EObject {
	/**
	 * Returns the value of the '<em><b>Bs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bs</em>' attribute list.
	 * @see test1.Test1uniquePackage#getConceptA_Bs()
	 * @model upper="10"
	 * @generated
	 */
	EList<Boolean> getBs();

} // ConceptA
