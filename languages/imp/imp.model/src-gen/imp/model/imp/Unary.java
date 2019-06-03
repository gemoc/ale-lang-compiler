/**
 */
package imp.model.imp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.Unary#getOp <em>Op</em>}</li>
 *   <li>{@link imp.model.imp.Unary#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getUnary()
 * @model
 * @generated
 */
public interface Unary extends Expr {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link imp.model.imp.UnaryOp}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see imp.model.imp.UnaryOp
	 * @see #setOp(UnaryOp)
	 * @see imp.model.imp.ImpPackage#getUnary_Op()
	 * @model
	 * @generated
	 */
	UnaryOp getOp();

	/**
	 * Sets the value of the '{@link imp.model.imp.Unary#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see imp.model.imp.UnaryOp
	 * @see #getOp()
	 * @generated
	 */
	void setOp(UnaryOp value);

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
	 * @see imp.model.imp.ImpPackage#getUnary_Expr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getExpr();

	/**
	 * Sets the value of the '{@link imp.model.imp.Unary#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expr value);

} // Unary
