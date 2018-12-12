/**
 */
package imp.model.imp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.VarRef#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getVarRef()
 * @model
 * @generated
 */
public interface VarRef extends Expr {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(Symbol)
	 * @see imp.model.imp.ImpPackage#getVarRef_Ref()
	 * @model required="true"
	 * @generated
	 */
	Symbol getRef();

	/**
	 * Sets the value of the '{@link imp.model.imp.VarRef#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Symbol value);

} // VarRef
