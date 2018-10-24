package minifsm.interpreter.minifsm;

import java.lang.String;
import minifsm.interpreter.minifsm.impl.MinifsmPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface MinifsmPackage extends EPackage {
  MinifsmPackage eINSTANCE = MinifsmPackageImpl.init();

  String eNS_URI = "http://minifsm.minifsm.minifsm/";

  String eNAME = "minifsm";

  String eNS_PREFIX = "minifsm";

  int MINIFSM_FEATURE_COUNT = 0;

  int FSM = 0;

  int STATE = 1;

  int TRANSITION = 2;

  int INITIAL = 3;

  int TERMINAL = 4;

  int FSM__STATES = 0;

  int FSM__TRANSITIONS = 1;

  int FSM__CURRENT_STATE = 2;

  int FSM__CURRENT_EVENT = 3;

  int STATE__NAME = 0;

  int TRANSITION__INCOMING = 0;

  int TRANSITION__OUTGOING = 1;

  int TRANSITION__FSM = 2;

  int TRANSITION__EVENT = 3;

  EClass getFSM();

  EClass getState();

  EClass getTransition();

  EClass getInitial();

  EClass getTerminal();

  EReference getFsm_States();

  EReference getFsm_Transitions();

  EReference getFsm_Current_state();

  EReference getTransition_Incoming();

  EReference getTransition_Outgoing();

  EReference getTransition_Fsm();

  EAttribute getFsm_Current_event();

  EAttribute getState_Name();

  EAttribute getTransition_Event();

  MinifsmFactory getMinifsmFactory();

  interface Literals {
    EClass FSM = eINSTANCE.getFSM();

    EClass STATE = eINSTANCE.getState();

    EClass TRANSITION = eINSTANCE.getTransition();

    EClass INITIAL = eINSTANCE.getInitial();

    EClass TERMINAL = eINSTANCE.getTerminal();

    EReference FSM__STATES = eINSTANCE.getFsm_States();

    EReference FSM__TRANSITIONS = eINSTANCE.getFsm_Transitions();

    EReference FSM__CURRENT_STATE = eINSTANCE.getFsm_Current_state();

    EReference TRANSITION__INCOMING = eINSTANCE.getTransition_Incoming();

    EReference TRANSITION__OUTGOING = eINSTANCE.getTransition_Outgoing();

    EReference TRANSITION__FSM = eINSTANCE.getTransition_Fsm();

    EAttribute FSM__CURRENT_EVENT = eINSTANCE.getFsm_Current_event();

    EAttribute STATE__NAME = eINSTANCE.getState_Name();

    EAttribute TRANSITION__EVENT = eINSTANCE.getTransition_Event();
  }
}
