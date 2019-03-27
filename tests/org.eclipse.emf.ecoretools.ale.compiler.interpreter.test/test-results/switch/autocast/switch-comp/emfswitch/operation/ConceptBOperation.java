package emfswitch.operation;

import autocast.ConceptB;
import emfswitch.SwitchImplementation;

public class ConceptBOperation extends ConceptAOperation {
	private final ConceptB it;

	private final SwitchImplementation emfswitch;

	public ConceptBOperation(ConceptB it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void callB() {
	}
}
