package minifsm.interpreter;

import minifsm.interpreter.impl.MinifsmFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface MinifsmFactory extends EFactory {
  MinifsmFactory eINSTANCE = MinifsmFactoryImpl.init();

  FSM createFSM();

  State createState();

  Transition createTransition();

  Initial createInitial();

  Terminal createTerminal();
}
