/**
 */
package boa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link boa.If#getCond <em>Cond</em>}</li>
 *   <li>{@link boa.If#getThn <em>Thn</em>}</li>
 *   <li>{@link boa.If#getEls <em>Els</em>}</li>
 * </ul>
 *
 * @see boa.BoaPackage#getIf()
 * @model
 * @generated
 */
public interface If extends Expr {
	/**
	 * Returns the value of the '<em><b>Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond</em>' containment reference.
	 * @see #setCond(Expr)
	 * @see boa.BoaPackage#getIf_Cond()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getCond();

	/**
	 * Sets the value of the '{@link boa.If#getCond <em>Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond</em>' containment reference.
	 * @see #getCond()
	 * @generated
	 */
	void setCond(Expr value);

	/**
	 * Returns the value of the '<em><b>Thn</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thn</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thn</em>' containment reference.
	 * @see #setThn(Expr)
	 * @see boa.BoaPackage#getIf_Thn()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getThn();

	/**
	 * Sets the value of the '{@link boa.If#getThn <em>Thn</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thn</em>' containment reference.
	 * @see #getThn()
	 * @generated
	 */
	void setThn(Expr value);

	/**
	 * Returns the value of the '<em><b>Els</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Els</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Els</em>' containment reference.
	 * @see #setEls(Expr)
	 * @see boa.BoaPackage#getIf_Els()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getEls();

	/**
	 * Sets the value of the '{@link boa.If#getEls <em>Els</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Els</em>' containment reference.
	 * @see #getEls()
	 * @generated
	 */
	void setEls(Expr value);

} // If
