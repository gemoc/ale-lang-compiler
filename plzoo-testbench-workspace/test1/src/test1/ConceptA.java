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
 *   <li>{@link test1.ConceptA#getB <em>B</em>}</li>
 * </ul>
 *
 * @see test1.Test1Package#getConceptA()
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
	 * @see test1.Test1Package#getConceptA_Bs()
	 * @model unique="false" upper="10"
	 * @generated
	 */
	EList<Boolean> getBs();

	/**
	 * Returns the value of the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>B</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>B</em>' attribute.
	 * @see #setB(long)
	 * @see test1.Test1Package#getConceptA_B()
	 * @model
	 * @generated
	 */
	long getB();

	/**
	 * Sets the value of the '{@link test1.ConceptA#getB <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>B</em>' attribute.
	 * @see #getB()
	 * @generated
	 */
	void setB(long value);

} // ConceptA
