/**
 */
package minifsm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see minifsm.MinifsmFactory
 * @model kind="package"
 * @generated
 */
public interface MinifsmPackage extends EPackage {
	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	MinifsmPackage eINSTANCE = minifsm.impl.MinifsmPackageImpl.init();
	
	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://minifsm";


	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "minifsm";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "minifsm";

	/**
	 * The meta object id for the '{@link minifsm.impl.FSMImpl <em>FSM</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see minifsm.impl.FSMImpl
	 * @see minifsm.impl.MinifsmPackageImpl#getFSM()
	 * @generated
	 */
	int FSM = 0;

	/**
	 * The meta object id for the '{@link minifsm.impl.StateImpl <em>State</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see minifsm.impl.StateImpl
	 * @see minifsm.impl.MinifsmPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The meta object id for the '{@link minifsm.impl.TransitionImpl
	 * <em>Transition</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see minifsm.impl.TransitionImpl
	 * @see minifsm.impl.MinifsmPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

	/**
	 * The meta object id for the '{@link minifsm.impl.InitialImpl
	 * <em>Initial</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see minifsm.impl.InitialImpl
	 * @see minifsm.impl.MinifsmPackageImpl#getInitial()
	 * @generated
	 */
	int INITIAL = 3;

	/**
	 * The meta object id for the '{@link minifsm.impl.TerminalImpl
	 * <em>Terminal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see minifsm.impl.TerminalImpl
	 * @see minifsm.impl.MinifsmPackageImpl#getTerminal()
	 * @generated
	 */
	int TERMINAL = 4;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FSM__STATES = 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FSM__TRANSITIONS = 1;

	/**
	 * The feature id for the '<em><b>Current State</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FSM__CURRENT_STATE = 2;

	/**
	 * The feature id for the '<em><b>Current Event</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FSM__CURRENT_EVENT = 3;

	/**
	 * The number of structural features of the '<em>FSM</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FSM_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Handle</em>' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FSM___HANDLE__STRING = 0;

	/**
	 * The number of operations of the '<em>FSM</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FSM_OPERATION_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The number of structural features of the '<em>State</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Execute</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE___EXECUTE = 0;

	/**
	 * The number of operations of the '<em>State</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION__INCOMING = 0;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OUTGOING = 1;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION__FSM = 2;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EVENT = 3;

	/**
	 * The number of structural features of the '<em>Transition</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Is Activated</em>' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION___IS_ACTIVATED = 0;

	/**
	 * The number of operations of the '<em>Transition</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INITIAL__NAME = STATE__NAME;

	/**
	 * The number of structural features of the '<em>Initial</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INITIAL_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INITIAL___EXECUTE = STATE___EXECUTE;

	/**
	 * The number of operations of the '<em>Initial</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INITIAL_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL__NAME = STATE__NAME;

	/**
	 * The number of structural features of the '<em>Terminal</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL___EXECUTE = STATE___EXECUTE;

	/**
	 * The number of operations of the '<em>Terminal</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link minifsm.FSM <em>FSM</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>FSM</em>'.
	 * @see minifsm.FSM
	 * @generated
	 */
	EClass getFSM();

	/**
	 * Returns the meta object for class '{@link minifsm.State <em>State</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>State</em>'.
	 * @see minifsm.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for class '{@link minifsm.Transition
	 * <em>Transition</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see minifsm.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for class '{@link minifsm.Initial <em>Initial</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Initial</em>'.
	 * @see minifsm.Initial
	 * @generated
	 */
	EClass getInitial();

	/**
	 * Returns the meta object for class '{@link minifsm.Terminal
	 * <em>Terminal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Terminal</em>'.
	 * @see minifsm.Terminal
	 * @generated
	 */
	EClass getTerminal();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link minifsm.FSM#getStates <em>States</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see minifsm.FSM#getStates()
	 * @see #getFSM()
	 * @generated
	 */
	EReference getFSM_States();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link minifsm.FSM#getTransitions <em>Transitions</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list
	 *         '<em>Transitions</em>'.
	 * @see minifsm.FSM#getTransitions()
	 * @see #getFSM()
	 * @generated
	 */
	EReference getFSM_Transitions();

	/**
	 * Returns the meta object for the reference '{@link minifsm.FSM#getCurrentState
	 * <em>Current State</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Current State</em>'.
	 * @see minifsm.FSM#getCurrentState()
	 * @see #getFSM()
	 * @generated
	 */
	EReference getFSM_CurrentState();

	/**
	 * Returns the meta object for the attribute '{@link minifsm.FSM#getCurrentEvent
	 * <em>Current Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Current Event</em>'.
	 * @see minifsm.FSM#getCurrentEvent()
	 * @see #getFSM()
	 * @generated
	 */
	EAttribute getFSM_CurrentEvent();

	/**
	 * Returns the meta object for the '{@link minifsm.FSM#handle(java.lang.String)
	 * <em>Handle</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Handle</em>' operation.
	 * @see minifsm.FSM#handle(java.lang.String)
	 * @generated
	 */
	EOperation getFSM__Handle__String();

	/**
	 * Returns the meta object for the attribute '{@link minifsm.State#getName
	 * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see minifsm.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the '{@link minifsm.State#execute()
	 * <em>Execute</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see minifsm.State#execute()
	 * @generated
	 */
	EOperation getState__Execute();

	/**
	 * Returns the meta object for the reference
	 * '{@link minifsm.Transition#getIncoming <em>Incoming</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Incoming</em>'.
	 * @see minifsm.Transition#getIncoming()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Incoming();

	/**
	 * Returns the meta object for the reference
	 * '{@link minifsm.Transition#getOutgoing <em>Outgoing</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Outgoing</em>'.
	 * @see minifsm.Transition#getOutgoing()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Outgoing();

	/**
	 * Returns the meta object for the container reference
	 * '{@link minifsm.Transition#getFsm <em>Fsm</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Fsm</em>'.
	 * @see minifsm.Transition#getFsm()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Fsm();

	/**
	 * Returns the meta object for the attribute '{@link minifsm.Transition#getEvent
	 * <em>Event</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see minifsm.Transition#getEvent()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Event();

	/**
	 * Returns the meta object for the '{@link minifsm.Transition#isActivated()
	 * <em>Is Activated</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the '<em>Is Activated</em>' operation.
	 * @see minifsm.Transition#isActivated()
	 * @generated
	 */
	EOperation getTransition__IsActivated();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MinifsmFactory getMinifsmFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link minifsm.impl.FSMImpl <em>FSM</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see minifsm.impl.FSMImpl
		 * @see minifsm.impl.MinifsmPackageImpl#getFSM()
		 * @generated
		 */
		EClass FSM = eINSTANCE.getFSM();

		/**
		 * The meta object literal for the '{@link minifsm.impl.StateImpl
		 * <em>State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see minifsm.impl.StateImpl
		 * @see minifsm.impl.MinifsmPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '{@link minifsm.impl.TransitionImpl
		 * <em>Transition</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see minifsm.impl.TransitionImpl
		 * @see minifsm.impl.MinifsmPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '{@link minifsm.impl.InitialImpl
		 * <em>Initial</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see minifsm.impl.InitialImpl
		 * @see minifsm.impl.MinifsmPackageImpl#getInitial()
		 * @generated
		 */
		EClass INITIAL = eINSTANCE.getInitial();

		/**
		 * The meta object literal for the '{@link minifsm.impl.TerminalImpl
		 * <em>Terminal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see minifsm.impl.TerminalImpl
		 * @see minifsm.impl.MinifsmPackageImpl#getTerminal()
		 * @generated
		 */
		EClass TERMINAL = eINSTANCE.getTerminal();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FSM__STATES = eINSTANCE.getFSM_States();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FSM__TRANSITIONS = eINSTANCE.getFSM_Transitions();

		/**
		 * The meta object literal for the '<em><b>Current State</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FSM__CURRENT_STATE = eINSTANCE.getFSM_CurrentState();

		/**
		 * The meta object literal for the '<em><b>Current Event</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FSM__CURRENT_EVENT = eINSTANCE.getFSM_CurrentEvent();

		/**
		 * The meta object literal for the '<em><b>Handle</b></em>' operation. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation FSM___HANDLE__STRING = eINSTANCE.getFSM__Handle__String();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation STATE___EXECUTE = eINSTANCE.getState__Execute();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSITION__INCOMING = eINSTANCE.getTransition_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSITION__OUTGOING = eINSTANCE.getTransition_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Fsm</b></em>' container reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSITION__FSM = eINSTANCE.getTransition_Fsm();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TRANSITION__EVENT = eINSTANCE.getTransition_Event();

		/**
		 * The meta object literal for the '<em><b>Is Activated</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation TRANSITION___IS_ACTIVATED = eINSTANCE.getTransition__IsActivated();
	}

} // MinifsmPackage
