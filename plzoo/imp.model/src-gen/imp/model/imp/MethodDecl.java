/**
 */
package imp.model.imp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.MethodDecl#getName <em>Name</em>}</li>
 *   <li>{@link imp.model.imp.MethodDecl#getStmt <em>Stmt</em>}</li>
 *   <li>{@link imp.model.imp.MethodDecl#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getMethodDecl()
 * @model
 * @generated
 */
public interface MethodDecl extends Member {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see imp.model.imp.ImpPackage#getMethodDecl_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link imp.model.imp.MethodDecl#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link imp.model.imp.ParamDecl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see imp.model.imp.ImpPackage#getMethodDecl_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParamDecl> getParams();

	/**
	 * Returns the value of the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stmt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stmt</em>' containment reference.
	 * @see #setStmt(Stmt)
	 * @see imp.model.imp.ImpPackage#getMethodDecl_Stmt()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Stmt getStmt();

	/**
	 * Sets the value of the '{@link imp.model.imp.MethodDecl#getStmt <em>Stmt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stmt</em>' containment reference.
	 * @see #getStmt()
	 * @generated
	 */
	void setStmt(Stmt value);

} // MethodDecl
