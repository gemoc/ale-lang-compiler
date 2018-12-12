/**
 */
package imp.model.imp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.Binary#getLhs <em>Lhs</em>}</li>
 *   <li>{@link imp.model.imp.Binary#getRhs <em>Rhs</em>}</li>
 *   <li>{@link imp.model.imp.Binary#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getBinary()
 * @model
 * @generated
 */
public interface Binary extends Expr {
	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' containment reference.
	 * @see #setLhs(Expr)
	 * @see imp.model.imp.ImpPackage#getBinary_Lhs()
	 * @model containment="true"
	 * @generated
	 */
	Expr getLhs();

	/**
	 * Sets the value of the '{@link imp.model.imp.Binary#getLhs <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' containment reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(Expr value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference.
	 * @see #setRhs(Expr)
	 * @see imp.model.imp.ImpPackage#getBinary_Rhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getRhs();

	/**
	 * Sets the value of the '{@link imp.model.imp.Binary#getRhs <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' containment reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(Expr value);

	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link imp.model.imp.BinaryOp}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see imp.model.imp.BinaryOp
	 * @see #setOp(BinaryOp)
	 * @see imp.model.imp.ImpPackage#getBinary_Op()
	 * @model
	 * @generated
	 */
	BinaryOp getOp();

	/**
	 * Sets the value of the '{@link imp.model.imp.Binary#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see imp.model.imp.BinaryOp
	 * @see #getOp()
	 * @generated
	 */
	void setOp(BinaryOp value);

} // Binary
