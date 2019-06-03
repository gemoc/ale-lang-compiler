package fsm.visitor.fsm;

import fsm.visitor.fsm.impl.FsmFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface FsmFactory extends EFactory {
	FsmFactory eINSTANCE = FsmFactoryImpl.init();

	FSM createFSM();

	State createState();

	Buffer createBuffer();

	Transition createTransition();

	System createSystem();

	FsmPackage getFsmPackage();
}
