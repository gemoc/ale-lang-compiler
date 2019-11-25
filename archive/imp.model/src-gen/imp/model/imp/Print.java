/**
 */
package imp.model.imp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Print</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.Print#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getPrint()
 * @model
 * @generated
 */
public interface Print extends Stmt {
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(Expr)
	 * @see imp.model.imp.ImpPackage#getPrint_Expr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getExpr();

	/**
	 * Sets the value of the '{@link imp.model.imp.Print#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expr value);

} // Print
