/**
 */
package imp.model.imp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.Block#getStmts <em>Stmts</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends Stmt {
	/**
	 * Returns the value of the '<em><b>Stmts</b></em>' containment reference list.
	 * The list contents are of type {@link imp.model.imp.Stmt}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stmts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stmts</em>' containment reference list.
	 * @see imp.model.imp.ImpPackage#getBlock_Stmts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Stmt> getStmts();

} // Block
