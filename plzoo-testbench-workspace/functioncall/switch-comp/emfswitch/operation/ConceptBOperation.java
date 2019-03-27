package emfswitch.operation;

import emfswitch.SwitchImplementation;
import x.y.z.functioncall.ConceptB;

public class ConceptBOperation extends ConceptAOperation {
	private final ConceptB it;

	private final SwitchImplementation emfswitch;

	public ConceptBOperation(ConceptB it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public ConceptB fct2() {
		ConceptB result;
		result = x.y.z.functioncall.FunctioncallFactory.eINSTANCE.createConceptB();
		return result;
	}
}
