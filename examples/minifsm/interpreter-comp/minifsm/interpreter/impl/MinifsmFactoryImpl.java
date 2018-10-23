package minifsm.interpreter.impl;

import java.lang.IllegalArgumentException;
import minifsm.interpreter.FSM;
import minifsm.interpreter.Initial;
import minifsm.interpreter.MinifsmFactory;
import minifsm.interpreter.MinifsmPackage;
import minifsm.interpreter.State;
import minifsm.interpreter.Terminal;
import minifsm.interpreter.Transition;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class MinifsmFactoryImpl extends EFactoryImpl implements MinifsmFactory {
  private MinifsmFactoryImpl() {
  }

  public static MinifsmFactory init() {
    try {
    	MinifsmFactory theMinifsmFactory = (MinifsmFactory) EPackage.Registry.INSTANCE.getEFactory(MinifsmPackage.eNS_URI);
    	if (theMinifsmFactory != null) {
    		return theMinifsmFactory;
    	}
    } catch (Exception exception) {
    	EcorePlugin.INSTANCE.log(exception);
    }
    return new MinifsmFactoryImpl();
  }

  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case MinifsmPackage.FSM:
    	return createFSM();
    case MinifsmPackage.STATE:
    	return createState();
    case MinifsmPackage.TRANSITION:
    	return createTransition();
    case MinifsmPackage.INITIAL:
    	return createInitial();
    case MinifsmPackage.TERMINAL:
    	return createTerminal();
    default:
    	throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  public FSM createFSM() {
    FSMImpl ret = new FSMImpl();
    return ret;
  }

  public State createState() {
    StateImpl ret = new StateImpl();
    return ret;
  }

  public Transition createTransition() {
    TransitionImpl ret = new TransitionImpl();
    return ret;
  }

  public Initial createInitial() {
    InitialImpl ret = new InitialImpl();
    return ret;
  }

  public Terminal createTerminal() {
    TerminalImpl ret = new TerminalImpl();
    return ret;
  }
}
