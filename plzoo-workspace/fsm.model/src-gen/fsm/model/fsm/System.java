/**
 */
package fsm.model.fsm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsm.model.fsm.System#getOwnedFsms <em>Owned Fsms</em>}</li>
 *   <li>{@link fsm.model.fsm.System#getOwnedBuffers <em>Owned Buffers</em>}</li>
 * </ul>
 *
 * @see fsm.model.fsm.FsmPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject {
	/**
	 * Returns the value of the '<em><b>Owned Fsms</b></em>' containment reference list.
	 * The list contents are of type {@link fsm.model.fsm.FSM}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Fsms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Fsms</em>' containment reference list.
	 * @see fsm.model.fsm.FsmPackage#getSystem_OwnedFsms()
	 * @model containment="true"
	 * @generated
	 */
	EList<FSM> getOwnedFsms();

	/**
	 * Returns the value of the '<em><b>Owned Buffers</b></em>' containment reference list.
	 * The list contents are of type {@link fsm.model.fsm.Buffer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Buffers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Buffers</em>' containment reference list.
	 * @see fsm.model.fsm.FsmPackage#getSystem_OwnedBuffers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Buffer> getOwnedBuffers();

} // System
