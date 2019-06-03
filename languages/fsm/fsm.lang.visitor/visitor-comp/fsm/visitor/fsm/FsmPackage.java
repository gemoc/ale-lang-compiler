package fsm.visitor.fsm;

import fsm.visitor.fsm.impl.FsmPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface FsmPackage extends EPackage {
	String eNAME = "fsm";

	String eNS_URI = "http://fsm.fsm.fsm/";

	String eNS_PREFIX = "fsm";

	FsmPackage eINSTANCE = FsmPackageImpl.init();

	int FSM = 0;

	int FSM__NAME = 0;

	int FSM__OWNED_STATES = 1;

	int FSM__OWNED_TRANSITIONS = 2;

	int FSM__INPUT_BUFFER = 3;

	int FSM__OUTPUT_BUFFER = 4;

	int FSM__INITIAL_STATE = 5;

	int FSM__CURRENT_STATE = 6;

	int FSM__UNDER_PROCESS_TRIGGER = 7;

	int FSM__CONSUMMED_STRING = 8;

	int FSM_FEATURE_COUNT = 9;

	int FSM_OPERATION_COUNT = 0;

	int STATE = 1;

	int STATE__INCOMING = 0;

	int STATE__NAME = 1;

	int STATE__OUTGOING = 2;

	int STATE__FSM = 3;

	int STATE_FEATURE_COUNT = 4;

	int STATE_OPERATION_COUNT = 0;

	int BUFFER = 2;

	int BUFFER__INITIAL_VALUE = 0;

	int BUFFER__OUTGOING_FSM = 1;

	int BUFFER__INCOMING_FSM = 2;

	int BUFFER__NAME = 3;

	int BUFFER__CURRENT_VALUES = 4;

	int BUFFER_FEATURE_COUNT = 5;

	int BUFFER_OPERATION_COUNT = 0;

	int TRANSITION = 3;

	int TRANSITION__TGT = 0;

	int TRANSITION__NAME = 1;

	int TRANSITION__SRC = 2;

	int TRANSITION__FSM = 3;

	int TRANSITION__TRIGGER = 4;

	int TRANSITION__ACTION = 5;

	int TRANSITION_FEATURE_COUNT = 6;

	int TRANSITION_OPERATION_COUNT = 0;

	int SYSTEM = 4;

	int SYSTEM__OWNED_FSMS = 0;

	int SYSTEM__OWNED_BUFFERS = 1;

	int SYSTEM_FEATURE_COUNT = 2;

	int SYSTEM_OPERATION_COUNT = 0;

	EClass getFSM();

	EAttribute getFSM_Name();

	EReference getFSM_OwnedStates();

	EReference getFSM_OwnedTransitions();

	EReference getFSM_InputBuffer();

	EReference getFSM_OutputBuffer();

	EReference getFSM_InitialState();

	EReference getFSM_CurrentState();

	EAttribute getFSM_UnderProcessTrigger();

	EAttribute getFSM_ConsummedString();

	EClass getState();

	EReference getState_Incoming();

	EAttribute getState_Name();

	EReference getState_Outgoing();

	EReference getState_Fsm();

	EClass getBuffer();

	EAttribute getBuffer_InitialValue();

	EReference getBuffer_OutgoingFSM();

	EReference getBuffer_IncomingFSM();

	EAttribute getBuffer_Name();

	EAttribute getBuffer_CurrentValues();

	EClass getTransition();

	EReference getTransition_Tgt();

	EAttribute getTransition_Name();

	EReference getTransition_Src();

	EReference getTransition_Fsm();

	EAttribute getTransition_Trigger();

	EAttribute getTransition_Action();

	EClass getSystem();

	EReference getSystem_OwnedFsms();

	EReference getSystem_OwnedBuffers();

	FsmFactory getFsmFactory();

	interface Literals {
		EClass FSM = eINSTANCE.getFSM();

		EAttribute FSM__NAME = eINSTANCE.getFSM_Name();

		EReference FSM__OWNED_STATES = eINSTANCE.getFSM_OwnedStates();

		EReference FSM__OWNED_TRANSITIONS = eINSTANCE.getFSM_OwnedTransitions();

		EReference FSM__INPUT_BUFFER = eINSTANCE.getFSM_InputBuffer();

		EReference FSM__OUTPUT_BUFFER = eINSTANCE.getFSM_OutputBuffer();

		EReference FSM__INITIAL_STATE = eINSTANCE.getFSM_InitialState();

		EReference FSM__CURRENT_STATE = eINSTANCE.getFSM_CurrentState();

		EAttribute FSM__UNDER_PROCESS_TRIGGER = eINSTANCE.getFSM_UnderProcessTrigger();

		EAttribute FSM__CONSUMMED_STRING = eINSTANCE.getFSM_ConsummedString();

		EClass STATE = eINSTANCE.getState();

		EReference STATE__INCOMING = eINSTANCE.getState_Incoming();

		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		EReference STATE__OUTGOING = eINSTANCE.getState_Outgoing();

		EReference STATE__FSM = eINSTANCE.getState_Fsm();

		EClass BUFFER = eINSTANCE.getBuffer();

		EAttribute BUFFER__INITIAL_VALUE = eINSTANCE.getBuffer_InitialValue();

		EReference BUFFER__OUTGOING_FSM = eINSTANCE.getBuffer_OutgoingFSM();

		EReference BUFFER__INCOMING_FSM = eINSTANCE.getBuffer_IncomingFSM();

		EAttribute BUFFER__NAME = eINSTANCE.getBuffer_Name();

		EAttribute BUFFER__CURRENT_VALUES = eINSTANCE.getBuffer_CurrentValues();

		EClass TRANSITION = eINSTANCE.getTransition();

		EReference TRANSITION__TGT = eINSTANCE.getTransition_Tgt();

		EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

		EReference TRANSITION__SRC = eINSTANCE.getTransition_Src();

		EReference TRANSITION__FSM = eINSTANCE.getTransition_Fsm();

		EAttribute TRANSITION__TRIGGER = eINSTANCE.getTransition_Trigger();

		EAttribute TRANSITION__ACTION = eINSTANCE.getTransition_Action();

		EClass SYSTEM = eINSTANCE.getSystem();

		EReference SYSTEM__OWNED_FSMS = eINSTANCE.getSystem_OwnedFsms();

		EReference SYSTEM__OWNED_BUFFERS = eINSTANCE.getSystem_OwnedBuffers();
	}
}
