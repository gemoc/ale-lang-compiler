/**
 */
package boa;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BObject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link boa.BObject#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see boa.BoaPackage#getBObject()
 * @model
 * @generated
 */
public interface BObject extends Expr {
	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link boa.Field}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see boa.BoaPackage#getBObject_Fields()
	 * @model containment="true"
	 * @generated
	 */
	EList<Field> getFields();

} // BObject
