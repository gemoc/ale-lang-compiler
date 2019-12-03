package emfswitch.operation;

import emfswitch.SwitchImplementation;
import x.y.z.functioncall.ConceptB;
import x.y.z.functioncall.FunctioncallFactory;

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
		result = ((ConceptB) (FunctioncallFactory.eINSTANCE.createConceptB()));
		return result;
	}
}
