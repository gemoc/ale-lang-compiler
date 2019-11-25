/**
 */
package imp.model.imp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.While#getCond <em>Cond</em>}</li>
 *   <li>{@link imp.model.imp.While#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getWhile()
 * @model
 * @generated
 */
public interface While extends Stmt {
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
	 * @see imp.model.imp.ImpPackage#getWhile_Cond()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getCond();

	/**
	 * Sets the value of the '{@link imp.model.imp.While#getCond <em>Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond</em>' containment reference.
	 * @see #getCond()
	 * @generated
	 */
	void setCond(Expr value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Stmt)
	 * @see imp.model.imp.ImpPackage#getWhile_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Stmt getBody();

	/**
	 * Sets the value of the '{@link imp.model.imp.While#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Stmt value);

} // While
