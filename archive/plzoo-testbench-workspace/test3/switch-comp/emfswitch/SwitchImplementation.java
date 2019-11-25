package emfswitch;

import emfswitch.operation.ConceptAOperation;
import emfswitch.operation.ConceptBOperation;
import emfswitch.operation.ConceptCOperation;
import java.lang.Object;
import java.lang.Override;
import test1.ConceptA;
import test1.ConceptB;
import test1.ConceptC;
import test1.util.Test1Switch;

public class SwitchImplementation extends Test1Switch<Object> {
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
