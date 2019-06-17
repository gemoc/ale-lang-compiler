package fsm.interpreter.fsm;

import org.eclipse.emf.ecore.EFactory;

import fsm.interpreter.fsm.impl.BufferImpl;
import fsm.interpreter.fsm.impl.FSMImpl;
import fsm.interpreter.fsm.impl.FsmFactoryImpl;
import fsm.interpreter.fsm.impl.StateImpl;
import fsm.interpreter.fsm.impl.SystemImpl;
import fsm.interpreter.fsm.impl.TransitionImpl;

public interface FsmFactory extends EFactory {
	FsmFactory eINSTANCE = FsmFactoryImpl.init();

	FSMImpl createFSM();

	StateImpl createState();

	BufferImpl createBuffer();

	TransitionImpl createTransition();

	SystemImpl createSystem();

	FsmPackage getFsmPackage();
}
