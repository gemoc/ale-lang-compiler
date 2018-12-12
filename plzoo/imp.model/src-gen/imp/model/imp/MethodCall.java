/**
 */
package imp.model.imp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.MethodCall#getParams <em>Params</em>}</li>
 *   <li>{@link imp.model.imp.MethodCall#getMethodref <em>Methodref</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getMethodCall()
 * @model
 * @generated
 */
public interface MethodCall extends Expr {
	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link imp.model.imp.Expr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see imp.model.imp.ImpPackage#getMethodCall_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expr> getParams();

	/**
	 * Returns the value of the '<em><b>Methodref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methodref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methodref</em>' reference.
	 * @see #setMethodref(MethodDecl)
	 * @see imp.model.imp.ImpPackage#getMethodCall_Methodref()
	 * @model required="true"
	 * @generated
	 */
	MethodDecl getMethodref();

	/**
	 * Sets the value of the '{@link imp.model.imp.MethodCall#getMethodref <em>Methodref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Methodref</em>' reference.
	 * @see #getMethodref()
	 * @generated
	 */
	void setMethodref(MethodDecl value);

} // MethodCall
