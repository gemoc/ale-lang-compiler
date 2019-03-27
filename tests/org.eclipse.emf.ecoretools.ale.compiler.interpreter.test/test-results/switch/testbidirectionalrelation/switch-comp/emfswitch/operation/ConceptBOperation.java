package emfswitch.operation;

import emfswitch.SwitchImplementation;
import testbidirectionalrelation.ConceptB;

public class ConceptBOperation {
	private final ConceptB it;

	private final SwitchImplementation emfswitch;

	public ConceptBOperation(ConceptB it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
