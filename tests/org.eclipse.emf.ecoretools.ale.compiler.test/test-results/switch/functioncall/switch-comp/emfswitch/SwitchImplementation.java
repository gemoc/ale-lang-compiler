package emfswitch;

import emfswitch.operation.ConceptAOperation;
import emfswitch.operation.ConceptBOperation;
import emfswitch.operation.ConceptCOperation;
import java.lang.Object;
import java.lang.Override;
import x.y.z.functioncall.ConceptA;
import x.y.z.functioncall.ConceptB;
import x.y.z.functioncall.ConceptC;
import x.y.z.functioncall.util.FunctioncallSwitch;

public class SwitchImplementation extends FunctioncallSwitch<Object> {
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
