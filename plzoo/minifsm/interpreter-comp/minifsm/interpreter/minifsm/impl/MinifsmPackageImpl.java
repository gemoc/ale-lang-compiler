package minifsm.interpreter.minifsm.impl;

import minifsm.interpreter.minifsm.MinifsmFactory;
import minifsm.interpreter.minifsm.MinifsmPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class MinifsmPackageImpl extends EPackageImpl implements MinifsmPackage {
  private static boolean isInited = false;

  private static boolean isCreated = false;

  private static boolean isInitialized = false;

  private EClass fSMEClass;

  private EClass stateEClass;

  private EClass transitionEClass;

  private EClass initialEClass;

  private EClass terminalEClass;

  private MinifsmPackageImpl() {
    super(eNS_URI, MinifsmFactory.eINSTANCE);}

  public static MinifsmPackage init() {
    if (isInited)
    	return (MinifsmPackage) EPackage.Registry.INSTANCE.getEPackage(MinifsmPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredMinifsmPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    minifsm.interpreter.minifsm.impl.MinifsmPackageImpl theMinifsmPackage;
    if(registeredMinifsmPackage instanceof minifsm.interpreter.minifsm.impl.MinifsmPackageImpl) {
    	 theMinifsmPackage =  (minifsm.interpreter.minifsm.impl.MinifsmPackageImpl) registeredMinifsmPackage;
    } else {
     	theMinifsmPackage = new minifsm.interpreter.minifsm.impl.MinifsmPackageImpl();
    }
    isInited = true;
    				
    // Create package meta-data objects
    theMinifsmPackage.createPackageContents();

    // Initialize created meta-data
    theMinifsmPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMinifsmPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MinifsmPackage.eNS_URI, theMinifsmPackage);
    return theMinifsmPackage;
  }

  public void createPackageContents() {
    if(isCreated) return;
    isCreated = true;

    fSMEClass = createEClass(FSM);
    createEReference(fSMEClass, FSM__STATES);
    createEReference(fSMEClass, FSM__TRANSITIONS);
    createEReference(fSMEClass, FSM__CURRENT_STATE);
    createEAttribute(fSMEClass, FSM__CURRENT_EVENT);
    stateEClass = createEClass(STATE);
    createEAttribute(stateEClass, STATE__NAME);
    transitionEClass = createEClass(TRANSITION);
    createEReference(transitionEClass, TRANSITION__INCOMING);
    createEReference(transitionEClass, TRANSITION__OUTGOING);
    createEReference(transitionEClass, TRANSITION__FSM);
    createEAttribute(transitionEClass, TRANSITION__EVENT);
    initialEClass = createEClass(INITIAL);
    terminalEClass = createEClass(TERMINAL);
  }

  public void initializePackageContents() {
    if (isInitialized)
    	return;
    isInitialized = true;
    //
    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);
    //
    // Create type parameters
    //
    // Set bounds for type parameters
    //
    // Add supertypes to classes
    initialEClass.getESuperTypes().add(this.getState());
    terminalEClass.getESuperTypes().add(this.getState());
    //
    // Initialize classes, features, and operations; add parameters
    initEClass(fSMEClass, minifsm.interpreter.minifsm.FSM.class, "FSM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFsm_States(), this.getState(),  
    	null, "states", null, 0, -1,  minifsm.interpreter.minifsm.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFsm_Transitions(), this.getTransition(),  
    	this.getTransition_Fsm(), "transitions", null, 0, -1,  minifsm.interpreter.minifsm.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFsm_Current_state(), this.getState(),  
    	null, "currentState", null, 0, 1,  minifsm.interpreter.minifsm.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFsm_Current_event(), ecorePackage.getEString(), "currentEvent", null, 0, 1,  minifsm.interpreter.minifsm.FSM.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(stateEClass, minifsm.interpreter.minifsm.State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getState_Name(), ecorePackage.getEString(), "name", null, 0, 1,  minifsm.interpreter.minifsm.State.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(transitionEClass, minifsm.interpreter.minifsm.Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransition_Incoming(), this.getState(),  
    	null, "incoming", null, 0, 1,  minifsm.interpreter.minifsm.Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_Outgoing(), this.getState(),  
    	null, "outgoing", null, 0, 1,  minifsm.interpreter.minifsm.Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_Fsm(), this.getFSM(),  
    	this.getFsm_Transitions(), "fsm", null, 0, 1,  minifsm.interpreter.minifsm.Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransition_Event(), ecorePackage.getEString(), "event", null, 0, 1,  minifsm.interpreter.minifsm.Transition.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(initialEClass, minifsm.interpreter.minifsm.Initial.class, "Initial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(terminalEClass, minifsm.interpreter.minifsm.Terminal.class, "Terminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    // Create resource
    createResource(eNS_URI);
  }

  public MinifsmFactory getMinifsmFactory() {
    return (MinifsmFactory) getEFactoryInstance();
  }

  public EClass getFSM() {
    return fSMEClass;}

  public EClass getState() {
    return stateEClass;}

  public EClass getTransition() {
    return transitionEClass;}

  public EClass getInitial() {
    return initialEClass;}

  public EClass getTerminal() {
    return terminalEClass;}

  public EReference getFsm_States() {
    return (EReference) fSMEClass.getEStructuralFeatures().get(0);}

  public EReference getFsm_Transitions() {
    return (EReference) fSMEClass.getEStructuralFeatures().get(1);}

  public EReference getFsm_Current_state() {
    return (EReference) fSMEClass.getEStructuralFeatures().get(2);}

  public EAttribute getFsm_Current_event() {
    return (EAttribute) fSMEClass.getEStructuralFeatures().get(3);}

  public EAttribute getState_Name() {
    return (EAttribute) stateEClass.getEStructuralFeatures().get(0);}

  public EReference getTransition_Incoming() {
    return (EReference) transitionEClass.getEStructuralFeatures().get(0);}

  public EReference getTransition_Outgoing() {
    return (EReference) transitionEClass.getEStructuralFeatures().get(1);}

  public EReference getTransition_Fsm() {
    return (EReference) transitionEClass.getEStructuralFeatures().get(2);}

  public EAttribute getTransition_Event() {
    return (EAttribute) transitionEClass.getEStructuralFeatures().get(3);}
}
