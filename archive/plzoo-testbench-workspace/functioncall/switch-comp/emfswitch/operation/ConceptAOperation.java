package emfswitch.operation;

import emfswitch.SwitchImplementation;
import x.y.z.functioncall.ConceptA;

public class ConceptAOperation {
	private final ConceptA it;

	private final SwitchImplementation emfswitch;

	public ConceptAOperation(ConceptA it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void fct1() {
	}

	public ConceptA fct2() {
		ConceptA result;
		result = x.y.z.functioncall.FunctioncallFactory.eINSTANCE.createConceptA();
		return result;
	}
}
