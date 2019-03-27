package emfswitch.operation;

import emfswitch.SwitchImplementation;
import x.y.z.functioncall.ConceptA;
import x.y.z.functioncall.ConceptB;
import x.y.z.functioncall.ConceptC;

public class ConceptCOperation {
	private final ConceptC it;

	private final SwitchImplementation emfswitch;

	public ConceptCOperation(ConceptC it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void exec1() {
		((ConceptAOperation) emfswitch.doSwitch(this.it.getConcepta1())).fct1();
		ConceptA tmpA = ((ConceptA)((emfswitch.operation.ConceptAOperation) emfswitch.doSwitch(this.it.getConcepta1())).fct2());
		((ConceptAOperation) emfswitch.doSwitch(this.it.getConcepta2())).fct1();
		ConceptA tmpB = ((ConceptA)((emfswitch.operation.ConceptAOperation) emfswitch.doSwitch(this.it.getConcepta2())).fct2());
		((ConceptBOperation) emfswitch.doSwitch(this.it.getConceptb())).fct1();
		ConceptB tmpC = ((ConceptB)((emfswitch.operation.ConceptBOperation) emfswitch.doSwitch(this.it.getConceptb())).fct2());
	}
}
