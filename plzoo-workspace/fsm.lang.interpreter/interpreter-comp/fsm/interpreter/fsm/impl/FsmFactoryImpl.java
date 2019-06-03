package fsm.interpreter.fsm.impl;

import fsm.interpreter.fsm.Buffer;
import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmFactory;
import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.State;
import fsm.interpreter.fsm.System;
import fsm.interpreter.fsm.Transition;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class FsmFactoryImpl extends EFactoryImpl implements FsmFactory {
	public FsmFactoryImpl() {
		super();
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

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FsmPackage.FSM :
				return createFSM();
			case FsmPackage.STATE :
				return createState();
			case FsmPackage.BUFFER :
				return createBuffer();
			case FsmPackage.TRANSITION :
				return createTransition();
			case FsmPackage.SYSTEM :
				return createSystem();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public FSM createFSM() {
		FSMImpl fsm = new FSMImpl();
		return fsm;
	}

	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	public Buffer createBuffer() {
		BufferImpl buffer = new BufferImpl();
		return buffer;
	}

	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	public System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	public FsmPackage getFsmPackage() {
		return (FsmPackage) getEPackage();
	}

	@Deprecated
	public static FsmPackage getPackage() {
		return FsmPackage.eINSTANCE;
	}
}
