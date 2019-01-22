package fsm.interpreter.fsm;

import fsm.interpreter.fsm.impl.FsmPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface FsmPackage extends EPackage {
  FsmPackage eINSTANCE = FsmPackageImpl.init();

  String eNS_URI = "http://fsm.fsm.fsm/";

  String eNAME = "fsm";

  String eNS_PREFIX = "fsm";

  int FSM = 0;

  int STATE = 1;

  int BUFFER = 2;

  int TRANSITION = 3;

  int SYSTEM = 4;

  int FSM__NAME = 0;

  int FSM__OWNED_STATES = 1;

  int FSM__OWNED_TRANSITIONS = 2;

  int FSM__INPUT_BUFFER = 3;

  int FSM__OUTPUT_BUFFER = 4;

  int FSM__INITIAL_STATE = 5;

  int FSM__CURRENT_STATE = 6;

  int FSM__UNDER_PROCESS_TRIGGER = 7;

  int FSM__CONSUMMED_STRING = 8;

  int STATE__INCOMING = 0;

  int STATE__NAME = 1;

  int STATE__OUTGOING = 2;

  int STATE__FSM = 3;

  int BUFFER__INITIAL_VALUE = 0;

  int BUFFER__OUTGOING_FSM = 1;

  int BUFFER__INCOMING_FSM = 2;

  int BUFFER__NAME = 3;

  int BUFFER__CURRENT_VALUES = 4;

  int TRANSITION__TGT = 0;

  int TRANSITION__NAME = 1;

  int TRANSITION__SRC = 2;

  int TRANSITION__FSM = 3;

  int TRANSITION__TRIGGER = 4;

  int TRANSITION__ACTION = 5;

  int SYSTEM__OWNED_FSMS = 0;

  int SYSTEM__OWNED_BUFFERS = 1;

  EClass getFSM();

  EClass getState();

  EClass getBuffer();

  EClass getTransition();

  EClass getSystem();

  EReference getFSM_OwnedStates();

  EReference getFSM_OwnedTransitions();

  EReference getFSM_InputBuffer();

  EReference getFSM_OutputBuffer();

  EReference getFSM_InitialState();

  EReference getFSM_CurrentState();

  EReference getState_Incoming();

  EReference getState_Outgoing();

  EReference getState_Fsm();

  EReference getBuffer_OutgoingFSM();

  EReference getBuffer_IncomingFSM();

  EReference getTransition_Tgt();

  EReference getTransition_Src();

  EReference getTransition_Fsm();

  EReference getSystem_OwnedFsms();

  EReference getSystem_OwnedBuffers();

  EAttribute getFSM_Name();

  EAttribute getFSM_UnderProcessTrigger();

  EAttribute getFSM_ConsummedString();

  EAttribute getState_Name();

  EAttribute getBuffer_InitialValue();

  EAttribute getBuffer_Name();

  EAttribute getBuffer_CurrentValues();

  EAttribute getTransition_Name();

  EAttribute getTransition_Trigger();

  EAttribute getTransition_Action();

  FsmFactory getFsmFactory();

  interface Literals {
    EClass FSM = eINSTANCE.getFSM();

    EClass STATE = eINSTANCE.getState();

    EClass BUFFER = eINSTANCE.getBuffer();

    EClass TRANSITION = eINSTANCE.getTransition();

    EClass SYSTEM = eINSTANCE.getSystem();

    EReference FSM__OWNED_STATES = eINSTANCE.getFSM_OwnedStates();

    EReference FSM__OWNED_TRANSITIONS = eINSTANCE.getFSM_OwnedTransitions();

    EReference FSM__INPUT_BUFFER = eINSTANCE.getFSM_InputBuffer();

    EReference FSM__OUTPUT_BUFFER = eINSTANCE.getFSM_OutputBuffer();

    EReference FSM__INITIAL_STATE = eINSTANCE.getFSM_InitialState();

    EReference FSM__CURRENT_STATE = eINSTANCE.getFSM_CurrentState();

    EReference STATE__INCOMING = eINSTANCE.getState_Incoming();

    EReference STATE__OUTGOING = eINSTANCE.getState_Outgoing();

    EReference STATE__FSM = eINSTANCE.getState_Fsm();

    EReference BUFFER__OUTGOING_FSM = eINSTANCE.getBuffer_OutgoingFSM();

    EReference BUFFER__INCOMING_FSM = eINSTANCE.getBuffer_IncomingFSM();

    EReference TRANSITION__TGT = eINSTANCE.getTransition_Tgt();

    EReference TRANSITION__SRC = eINSTANCE.getTransition_Src();

    EReference TRANSITION__FSM = eINSTANCE.getTransition_Fsm();

    EReference SYSTEM__OWNED_FSMS = eINSTANCE.getSystem_OwnedFsms();

    EReference SYSTEM__OWNED_BUFFERS = eINSTANCE.getSystem_OwnedBuffers();

    EAttribute FSM__NAME = eINSTANCE.getFSM_Name();

    EAttribute FSM__UNDER_PROCESS_TRIGGER = eINSTANCE.getFSM_UnderProcessTrigger();

    EAttribute FSM__CONSUMMED_STRING = eINSTANCE.getFSM_ConsummedString();

    EAttribute STATE__NAME = eINSTANCE.getState_Name();

    EAttribute BUFFER__INITIAL_VALUE = eINSTANCE.getBuffer_InitialValue();

    EAttribute BUFFER__NAME = eINSTANCE.getBuffer_Name();

    EAttribute BUFFER__CURRENT_VALUES = eINSTANCE.getBuffer_CurrentValues();

    EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

    EAttribute TRANSITION__TRIGGER = eINSTANCE.getTransition_Trigger();

    EAttribute TRANSITION__ACTION = eINSTANCE.getTransition_Action();
  }
}
