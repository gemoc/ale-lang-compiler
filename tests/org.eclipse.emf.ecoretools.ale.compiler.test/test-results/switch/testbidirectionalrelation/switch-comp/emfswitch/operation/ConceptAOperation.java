package emfswitch.operation;

import emfswitch.SwitchImplementation;
import testbidirectionalrelation.ConceptA;

public class ConceptAOperation {
	private final ConceptA it;

	private final SwitchImplementation emfswitch;

	public ConceptAOperation(ConceptA it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
