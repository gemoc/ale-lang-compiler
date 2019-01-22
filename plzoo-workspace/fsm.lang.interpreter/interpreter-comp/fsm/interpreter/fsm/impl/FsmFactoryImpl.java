package fsm.interpreter.fsm.impl;

import fsm.interpreter.fsm.Buffer;
import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmFactory;
import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.State;
import fsm.interpreter.fsm.System;
import fsm.interpreter.fsm.Transition;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class FsmFactoryImpl extends EFactoryImpl implements FsmFactory {
  public FsmFactoryImpl() {
  }

  public static FsmFactory init() {
    try {
    	FsmFactory theFsmFactory = (FsmFactory) EPackage.Registry.INSTANCE.getEFactory(FsmPackage.eNS_URI);
    	if (theFsmFactory != null) {
    		return theFsmFactory;
    	}
    } catch (Exception exception) {
    	EcorePlugin.INSTANCE.log(exception);
    }
    return new FsmFactoryImpl();
  }

  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case FsmPackage.FSM:
    	return createFSM();
    case FsmPackage.STATE:
    	return createState();
    case FsmPackage.BUFFER:
    	return createBuffer();
    case FsmPackage.TRANSITION:
    	return createTransition();
    case FsmPackage.SYSTEM:
    	return createSystem();
    default:
    	throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
    default:
    	throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    default:
    	throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  public FsmPackage getFsmPackage() {
    return (FsmPackage)getEPackage();}

  public FSM createFSM() {
    FSMImpl ret = new FSMImpl();
    return ret;
  }

  public State createState() {
    StateImpl ret = new StateImpl();
    return ret;
  }

  public Buffer createBuffer() {
    BufferImpl ret = new BufferImpl();
    return ret;
  }

  public Transition createTransition() {
    TransitionImpl ret = new TransitionImpl();
    return ret;
  }

  public System createSystem() {
    SystemImpl ret = new SystemImpl();
    return ret;
  }
}
