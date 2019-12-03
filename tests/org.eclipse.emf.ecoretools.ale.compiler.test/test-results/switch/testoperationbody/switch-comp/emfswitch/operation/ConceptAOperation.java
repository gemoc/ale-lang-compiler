package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Boolean;
import testoperationbody.ConceptA;

public class ConceptAOperation {
	private final ConceptA it;

	private final SwitchImplementation emfswitch;

	public ConceptAOperation(ConceptA it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public boolean op() {
		boolean result;
		result = ((Boolean) (false));
		return result;
	}
}
