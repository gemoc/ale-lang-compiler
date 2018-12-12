/**
 */
package imp.model.imp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.Program#getMethods <em>Methods</em>}</li>
 *   <li>{@link imp.model.imp.Program#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject {
	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link imp.model.imp.MethodDecl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see imp.model.imp.ImpPackage#getProgram_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<MethodDecl> getMethods();

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link imp.model.imp.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see imp.model.imp.ImpPackage#getProgram_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<imp.model.imp.Class> getClasses();

} // Program
