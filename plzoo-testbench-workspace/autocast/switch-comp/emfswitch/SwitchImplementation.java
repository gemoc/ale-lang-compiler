package emfswitch;

import autocast.ConceptA;
import autocast.ConceptB;
import autocast.ConceptC;
import autocast.util.AutocastSwitch;
import emfswitch.operation.ConceptAOperation;
import emfswitch.operation.ConceptBOperation;
import emfswitch.operation.ConceptCOperation;
import java.lang.Object;
import java.lang.Override;

public class SwitchImplementation extends AutocastSwitch<Object> {
	@Override
	public Object caseConceptA(ConceptA it) {
		return new ConceptAOperation(it, this);
	}

	@Override
	public Object caseConceptB(ConceptB it) {
		return new ConceptBOperation(it, this);
	}

	@Override
	public Object caseConceptC(ConceptC it) {
		return new ConceptCOperation(it, this);
	}
}
