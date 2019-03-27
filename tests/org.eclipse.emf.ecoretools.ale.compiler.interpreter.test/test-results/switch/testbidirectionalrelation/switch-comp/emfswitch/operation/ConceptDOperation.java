package emfswitch.operation;

import emfswitch.SwitchImplementation;
import testbidirectionalrelation.ConceptD;

public class ConceptDOperation {
	private final ConceptD it;

	private final SwitchImplementation emfswitch;

	public ConceptDOperation(ConceptD it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
