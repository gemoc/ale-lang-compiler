/**
 */
package boa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Copy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link boa.Copy#getCopy <em>Copy</em>}</li>
 * </ul>
 *
 * @see boa.BoaPackage#getCopy()
 * @model
 * @generated
 */
public interface Copy extends Expr {
	/**
	 * Returns the value of the '<em><b>Copy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy</em>' containment reference.
	 * @see #setCopy(Expr)
	 * @see boa.BoaPackage#getCopy_Copy()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getCopy();

	/**
	 * Sets the value of the '{@link boa.Copy#getCopy <em>Copy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copy</em>' containment reference.
	 * @see #getCopy()
	 * @generated
	 */
	void setCopy(Expr value);

} // Copy
