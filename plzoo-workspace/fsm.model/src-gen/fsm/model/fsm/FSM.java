/**
 */
package fsm.model.fsm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsm.model.fsm.FSM#getName <em>Name</em>}</li>
 *   <li>{@link fsm.model.fsm.FSM#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link fsm.model.fsm.FSM#getOwnedTransitions <em>Owned Transitions</em>}</li>
 *   <li>{@link fsm.model.fsm.FSM#getInputBuffer <em>Input Buffer</em>}</li>
 *   <li>{@link fsm.model.fsm.FSM#getOutputBuffer <em>Output Buffer</em>}</li>
 *   <li>{@link fsm.model.fsm.FSM#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link fsm.model.fsm.FSM#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link fsm.model.fsm.FSM#getUnderProcessTrigger <em>Under Process Trigger</em>}</li>
 *   <li>{@link fsm.model.fsm.FSM#getConsummedString <em>Consummed String</em>}</li>
 * </ul>
 *
 * @see fsm.model.fsm.FsmPackage#getFSM()
 * @model
 * @generated
 */
public interface FSM extends EObject {
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
	 * @see fsm.model.fsm.FsmPackage#getFSM_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fsm.model.fsm.FSM#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned States</b></em>' containment reference list.
	 * The list contents are of type {@link fsm.model.fsm.State}.
	 * It is bidirectional and its opposite is '{@link fsm.model.fsm.State#getFsm <em>Fsm</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned States</em>' containment reference list.
	 * @see fsm.model.fsm.FsmPackage#getFSM_OwnedStates()
	 * @see fsm.model.fsm.State#getFsm
	 * @model opposite="fsm" containment="true"
	 * @generated
	 */
	EList<State> getOwnedStates();

	/**
	 * Returns the value of the '<em><b>Owned Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link fsm.model.fsm.Transition}.
	 * It is bidirectional and its opposite is '{@link fsm.model.fsm.Transition#getFsm <em>Fsm</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Transitions</em>' containment reference list.
	 * @see fsm.model.fsm.FsmPackage#getFSM_OwnedTransitions()
	 * @see fsm.model.fsm.Transition#getFsm
	 * @model opposite="fsm" containment="true"
	 * @generated
	 */
	EList<Transition> getOwnedTransitions();

	/**
	 * Returns the value of the '<em><b>Input Buffer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link fsm.model.fsm.Buffer#getOutgoingFSM <em>Outgoing FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Buffer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Buffer</em>' reference.
	 * @see #setInputBuffer(Buffer)
	 * @see fsm.model.fsm.FsmPackage#getFSM_InputBuffer()
	 * @see fsm.model.fsm.Buffer#getOutgoingFSM
	 * @model opposite="outgoingFSM"
	 * @generated
	 */
	Buffer getInputBuffer();

	/**
	 * Sets the value of the '{@link fsm.model.fsm.FSM#getInputBuffer <em>Input Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Buffer</em>' reference.
	 * @see #getInputBuffer()
	 * @generated
	 */
	void setInputBuffer(Buffer value);

	/**
	 * Returns the value of the '<em><b>Output Buffer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link fsm.model.fsm.Buffer#getIncomingFSM <em>Incoming FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Buffer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Buffer</em>' reference.
	 * @see #setOutputBuffer(Buffer)
	 * @see fsm.model.fsm.FsmPackage#getFSM_OutputBuffer()
	 * @see fsm.model.fsm.Buffer#getIncomingFSM
	 * @model opposite="incomingFSM"
	 * @generated
	 */
	Buffer getOutputBuffer();

	/**
	 * Sets the value of the '{@link fsm.model.fsm.FSM#getOutputBuffer <em>Output Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Buffer</em>' reference.
	 * @see #getOutputBuffer()
	 * @generated
	 */
	void setOutputBuffer(Buffer value);

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see fsm.model.fsm.FsmPackage#getFSM_InitialState()
	 * @model
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link fsm.model.fsm.FSM#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State</em>' reference.
	 * @see #setCurrentState(State)
	 * @see fsm.model.fsm.FsmPackage#getFSM_CurrentState()
	 * @model
	 * @generated
	 */
	State getCurrentState();

	/**
	 * Sets the value of the '{@link fsm.model.fsm.FSM#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(State value);

	/**
	 * Returns the value of the '<em><b>Under Process Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Under Process Trigger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Under Process Trigger</em>' attribute.
	 * @see #setUnderProcessTrigger(String)
	 * @see fsm.model.fsm.FsmPackage#getFSM_UnderProcessTrigger()
	 * @model
	 * @generated
	 */
	String getUnderProcessTrigger();

	/**
	 * Sets the value of the '{@link fsm.model.fsm.FSM#getUnderProcessTrigger <em>Under Process Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Under Process Trigger</em>' attribute.
	 * @see #getUnderProcessTrigger()
	 * @generated
	 */
	void setUnderProcessTrigger(String value);

	/**
	 * Returns the value of the '<em><b>Consummed String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consummed String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consummed String</em>' attribute.
	 * @see #setConsummedString(String)
	 * @see fsm.model.fsm.FsmPackage#getFSM_ConsummedString()
	 * @model
	 * @generated
	 */
	String getConsummedString();

	/**
	 * Sets the value of the '{@link fsm.model.fsm.FSM#getConsummedString <em>Consummed String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consummed String</em>' attribute.
	 * @see #getConsummedString()
	 * @generated
	 */
	void setConsummedString(String value);

} // FSM
