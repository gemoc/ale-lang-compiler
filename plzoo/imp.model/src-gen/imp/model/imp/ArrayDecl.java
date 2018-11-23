/**
 */
package imp.model.imp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.ArrayDecl#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getArrayDecl()
 * @model
 * @generated
 */
public interface ArrayDecl extends Expr {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link imp.model.imp.Expr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see imp.model.imp.ImpPackage#getArrayDecl_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expr> getValues();

} // ArrayDecl
