/**
 */
package imp.model.imp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.Project#getLhs <em>Lhs</em>}</li>
 *   <li>{@link imp.model.imp.Project#getRhs <em>Rhs</em>}</li>
 *   <li>{@link imp.model.imp.Project#isIsmethodcall <em>Ismethodcall</em>}</li>
 *   <li>{@link imp.model.imp.Project#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends Expr {
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
	 * @see imp.model.imp.ImpPackage#getProject_Lhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getLhs();

	/**
	 * Sets the value of the '{@link imp.model.imp.Project#getLhs <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' containment reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(Expr value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' reference.
	 * @see #setRhs(Member)
	 * @see imp.model.imp.ImpPackage#getProject_Rhs()
	 * @model required="true"
	 * @generated
	 */
	Member getRhs();

	/**
	 * Sets the value of the '{@link imp.model.imp.Project#getRhs <em>Rhs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(Member value);

	/**
	 * Returns the value of the '<em><b>Ismethodcall</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ismethodcall</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ismethodcall</em>' attribute.
	 * @see #setIsmethodcall(boolean)
	 * @see imp.model.imp.ImpPackage#getProject_Ismethodcall()
	 * @model
	 * @generated
	 */
	boolean isIsmethodcall();

	/**
	 * Sets the value of the '{@link imp.model.imp.Project#isIsmethodcall <em>Ismethodcall</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ismethodcall</em>' attribute.
	 * @see #isIsmethodcall()
	 * @generated
	 */
	void setIsmethodcall(boolean value);

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
	 * @see imp.model.imp.ImpPackage#getProject_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expr> getParams();

} // Project
