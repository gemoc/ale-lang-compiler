/**
 */
package testoperationbody;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testoperationbody.ChildA#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see testoperationbody.TestoperationbodyPackage#getChildA()
 * @model
 * @generated
 */
public interface ChildA extends Parent {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link testoperationbody.EnumA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see testoperationbody.EnumA
	 * @see #setValue(EnumA)
	 * @see testoperationbody.TestoperationbodyPackage#getChildA_Value()
	 * @model
	 * @generated
	 */
	EnumA getValue();

	/**
	 * Sets the value of the '{@link testoperationbody.ChildA#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see testoperationbody.EnumA
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EnumA value);

} // ChildA
