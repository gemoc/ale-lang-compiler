package minifsm.revisitor.test;

import org.junit.Test;

import minifsm.interpreter.minifsm.FSM;
import minifsm.interpreter.minifsm.Initial;
import minifsm.interpreter.minifsm.MinifsmFactory;
import minifsm.interpreter.minifsm.State;
import minifsm.interpreter.minifsm.Terminal;
import minifsm.interpreter.minifsm.Transition;

public class MinifsmCompiledInterpreterFactoryTest {
	@Test
	public void test() throws Exception {
		MinifsmFactory f = MinifsmFactory.eINSTANCE;
		FSM fsm = f.createFSM();
		Initial initial = f.createInitial();
		initial.setName("Initial");
		fsm.getStates().add(initial);
		State s2 = f.createState();
		s2.setName("Second");
		fsm.getStates().add(s2);
		Terminal terminal = f.createTerminal();
		terminal.setName("Terminal");
		fsm.getStates().add(terminal);
		Transition t1 = f.createTransition();
		t1.setEvent("event1");
		t1.setIncoming(initial);
		t1.setOutgoing(s2);
		fsm.getTransitions().add(t1);
		Transition t2 = f.createTransition();
		t2.setEvent("event2");
		t2.setIncoming(s2);
		t2.setOutgoing(terminal);
		fsm.getTransitions().add(t2);

		fsm.entryPoint();
		
		System.out.println(fsm);
	}
}
