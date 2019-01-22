package fsm.interpreter.fsm.impl;

import fsm.interpreter.fsm.FsmFactory;
import fsm.interpreter.fsm.FsmPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class FsmPackageImpl extends EPackageImpl implements FsmPackage {
  private static boolean isInited = false;

  private boolean isCreated = false;

  private boolean isInitialized = false;

  private EClass fSMEClass = null;

  private EClass stateEClass = null;

  private EClass bufferEClass = null;

  private EClass transitionEClass = null;

  private EClass systemEClass = null;

  private FsmPackageImpl() {
    super(eNS_URI, FsmFactory.eINSTANCE);
  }

  public static FsmPackage init() {
    if (isInited)
    	return (FsmPackage) EPackage.Registry.INSTANCE.getEPackage(FsmPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredFsmPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    fsm.interpreter.fsm.impl.FsmPackageImpl theFsmPackage;
    if(registeredFsmPackage instanceof fsm.interpreter.fsm.impl.FsmPackageImpl) {
    	 theFsmPackage =  (fsm.interpreter.fsm.impl.FsmPackageImpl) registeredFsmPackage;
    } else {
     	theFsmPackage = new fsm.interpreter.fsm.impl.FsmPackageImpl();
    }
    isInited = true;
    				
    // Create package meta-data objects
    theFsmPackage.createPackageContents();

    // Initialize created meta-data
    theFsmPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFsmPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FsmPackage.eNS_URI, theFsmPackage);
    return theFsmPackage;
  }

  public void createPackageContents() {
    if(isCreated)
    	return;
    isCreated = true;

    fSMEClass = createEClass(FSM);
    createEAttribute(fSMEClass, FSM__NAME);
    createEReference(fSMEClass, FSM__OWNED_STATES);
    createEReference(fSMEClass, FSM__OWNED_TRANSITIONS);
    createEReference(fSMEClass, FSM__INPUT_BUFFER);
    createEReference(fSMEClass, FSM__OUTPUT_BUFFER);
    createEReference(fSMEClass, FSM__INITIAL_STATE);
    createEReference(fSMEClass, FSM__CURRENT_STATE);
    createEAttribute(fSMEClass, FSM__UNDER_PROCESS_TRIGGER);
    createEAttribute(fSMEClass, FSM__CONSUMMED_STRING);
    stateEClass = createEClass(STATE);
    createEReference(stateEClass, STATE__INCOMING);
    createEAttribute(stateEClass, STATE__NAME);
    createEReference(stateEClass, STATE__OUTGOING);
    createEReference(stateEClass, STATE__FSM);
    bufferEClass = createEClass(BUFFER);
    createEAttribute(bufferEClass, BUFFER__INITIAL_VALUE);
    createEReference(bufferEClass, BUFFER__OUTGOING_FSM);
    createEReference(bufferEClass, BUFFER__INCOMING_FSM);
    createEAttribute(bufferEClass, BUFFER__NAME);
    createEAttribute(bufferEClass, BUFFER__CURRENT_VALUES);
    transitionEClass = createEClass(TRANSITION);
    createEReference(transitionEClass, TRANSITION__TGT);
    createEAttribute(transitionEClass, TRANSITION__NAME);
    createEReference(transitionEClass, TRANSITION__SRC);
    createEReference(transitionEClass, TRANSITION__FSM);
    createEAttribute(transitionEClass, TRANSITION__TRIGGER);
    createEAttribute(transitionEClass, TRANSITION__ACTION);
    systemEClass = createEClass(SYSTEM);
    createEReference(systemEClass, SYSTEM__OWNED_FSMS);
    createEReference(systemEClass, SYSTEM__OWNED_BUFFERS);
  }

  public void initializePackageContents() {
    if (isInitialized)
    	return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(fSMEClass, fsm.interpreter.fsm.FSM.class, "FSM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFSM_Name(), ecorePackage.getEString(), "name", null, 0, 1,  fsm.interpreter.fsm.FSM.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getFSM_OwnedStates(), this.getState(),  
    	this.getState_Fsm(), "ownedStates", null, 0, -1,  fsm.interpreter.fsm.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFSM_OwnedTransitions(), this.getTransition(),  
    	this.getTransition_Fsm(), "ownedTransitions", null, 0, -1,  fsm.interpreter.fsm.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFSM_InputBuffer(), this.getBuffer(),  
    	this.getBuffer_OutgoingFSM(), "inputBuffer", null, 0, 1,  fsm.interpreter.fsm.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFSM_OutputBuffer(), this.getBuffer(),  
    	this.getBuffer_IncomingFSM(), "outputBuffer", null, 0, 1,  fsm.interpreter.fsm.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFSM_InitialState(), this.getState(),  
    	null, "initialState", null, 0, 1,  fsm.interpreter.fsm.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFSM_CurrentState(), this.getState(),  
    	null, "currentState", null, 0, 1,  fsm.interpreter.fsm.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFSM_UnderProcessTrigger(), ecorePackage.getEString(), "underProcessTrigger", null, 0, 1,  fsm.interpreter.fsm.FSM.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEAttribute(getFSM_ConsummedString(), ecorePackage.getEString(), "consummedString", null, 0, 1,  fsm.interpreter.fsm.FSM.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(stateEClass, fsm.interpreter.fsm.State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getState_Incoming(), this.getTransition(),  
    	this.getTransition_Tgt(), "incoming", null, 0, -1,  fsm.interpreter.fsm.State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getState_Name(), ecorePackage.getEString(), "name", null, 0, 1,  fsm.interpreter.fsm.State.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getState_Outgoing(), this.getTransition(),  
    	this.getTransition_Src(), "outgoing", null, 0, -1,  fsm.interpreter.fsm.State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_Fsm(), this.getFSM(),  
    	this.getFSM_OwnedStates(), "fsm", null, 0, 1,  fsm.interpreter.fsm.State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(bufferEClass, fsm.interpreter.fsm.Buffer.class, "Buffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBuffer_InitialValue(), ecorePackage.getEString(), "initialValue", null, 0, 1,  fsm.interpreter.fsm.Buffer.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getBuffer_OutgoingFSM(), this.getFSM(),  
    	this.getFSM_InputBuffer(), "outgoingFSM", null, 0, 1,  fsm.interpreter.fsm.Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBuffer_IncomingFSM(), this.getFSM(),  
    	this.getFSM_OutputBuffer(), "incomingFSM", null, 0, 1,  fsm.interpreter.fsm.Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBuffer_Name(), ecorePackage.getEString(), "name", null, 0, 1,  fsm.interpreter.fsm.Buffer.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEAttribute(getBuffer_CurrentValues(), ecorePackage.getEString(), "currentValues", null, 0, 1,  fsm.interpreter.fsm.Buffer.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(transitionEClass, fsm.interpreter.fsm.Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransition_Tgt(), this.getState(),  
    	this.getState_Incoming(), "tgt", null, 0, 1,  fsm.interpreter.fsm.Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransition_Name(), ecorePackage.getEString(), "name", null, 0, 1,  fsm.interpreter.fsm.Transition.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getTransition_Src(), this.getState(),  
    	this.getState_Outgoing(), "src", null, 0, 1,  fsm.interpreter.fsm.Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_Fsm(), this.getFSM(),  
    	this.getFSM_OwnedTransitions(), "fsm", null, 0, 1,  fsm.interpreter.fsm.Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransition_Trigger(), ecorePackage.getEString(), "trigger", null, 0, 1,  fsm.interpreter.fsm.Transition.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEAttribute(getTransition_Action(), ecorePackage.getEString(), "action", null, 0, 1,  fsm.interpreter.fsm.Transition.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(systemEClass, fsm.interpreter.fsm.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSystem_OwnedFsms(), this.getFSM(),  
    	null, "ownedFsms", null, 0, -1,  fsm.interpreter.fsm.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSystem_OwnedBuffers(), this.getBuffer(),  
    	null, "ownedBuffers", null, 0, -1,  fsm.interpreter.fsm.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    // Create resource
    createResource(eNS_URI);
  }

  public FsmFactory getFsmFactory() {
    return (FsmFactory) getEFactoryInstance();
  }

  public EClass getFSM() {
    return fSMEClass;
  }

  public EClass getState() {
    return stateEClass;
  }

  public EClass getBuffer() {
    return bufferEClass;
  }

  public EClass getTransition() {
    return transitionEClass;
  }

  public EClass getSystem() {
    return systemEClass;
  }

  public EAttribute getFSM_Name() {
    return (EAttribute) fSMEClass.getEStructuralFeatures().get(0);
  }

  public EReference getFSM_OwnedStates() {
    return (EReference) fSMEClass.getEStructuralFeatures().get(1);
  }

  public EReference getFSM_OwnedTransitions() {
    return (EReference) fSMEClass.getEStructuralFeatures().get(2);
  }

  public EReference getFSM_InputBuffer() {
    return (EReference) fSMEClass.getEStructuralFeatures().get(3);
  }

  public EReference getFSM_OutputBuffer() {
    return (EReference) fSMEClass.getEStructuralFeatures().get(4);
  }

  public EReference getFSM_InitialState() {
    return (EReference) fSMEClass.getEStructuralFeatures().get(5);
  }

  public EReference getFSM_CurrentState() {
    return (EReference) fSMEClass.getEStructuralFeatures().get(6);
  }

  public EAttribute getFSM_UnderProcessTrigger() {
    return (EAttribute) fSMEClass.getEStructuralFeatures().get(7);
  }

  public EAttribute getFSM_ConsummedString() {
    return (EAttribute) fSMEClass.getEStructuralFeatures().get(8);
  }

  public EReference getState_Incoming() {
    return (EReference) stateEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getState_Name() {
    return (EAttribute) stateEClass.getEStructuralFeatures().get(1);
  }

  public EReference getState_Outgoing() {
    return (EReference) stateEClass.getEStructuralFeatures().get(2);
  }

  public EReference getState_Fsm() {
    return (EReference) stateEClass.getEStructuralFeatures().get(3);
  }

  public EAttribute getBuffer_InitialValue() {
    return (EAttribute) bufferEClass.getEStructuralFeatures().get(0);
  }

  public EReference getBuffer_OutgoingFSM() {
    return (EReference) bufferEClass.getEStructuralFeatures().get(1);
  }

  public EReference getBuffer_IncomingFSM() {
    return (EReference) bufferEClass.getEStructuralFeatures().get(2);
  }

  public EAttribute getBuffer_Name() {
    return (EAttribute) bufferEClass.getEStructuralFeatures().get(3);
  }

  public EAttribute getBuffer_CurrentValues() {
    return (EAttribute) bufferEClass.getEStructuralFeatures().get(4);
  }

  public EReference getTransition_Tgt() {
    return (EReference) transitionEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getTransition_Name() {
    return (EAttribute) transitionEClass.getEStructuralFeatures().get(1);
  }

  public EReference getTransition_Src() {
    return (EReference) transitionEClass.getEStructuralFeatures().get(2);
  }

  public EReference getTransition_Fsm() {
    return (EReference) transitionEClass.getEStructuralFeatures().get(3);
  }

  public EAttribute getTransition_Trigger() {
    return (EAttribute) transitionEClass.getEStructuralFeatures().get(4);
  }

  public EAttribute getTransition_Action() {
    return (EAttribute) transitionEClass.getEStructuralFeatures().get(5);
  }

  public EReference getSystem_OwnedFsms() {
    return (EReference) systemEClass.getEStructuralFeatures().get(0);
  }

  public EReference getSystem_OwnedBuffers() {
    return (EReference) systemEClass.getEStructuralFeatures().get(1);
  }
}
