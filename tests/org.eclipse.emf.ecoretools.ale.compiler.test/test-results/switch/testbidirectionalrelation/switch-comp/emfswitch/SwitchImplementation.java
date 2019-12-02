package emfswitch;

import emfswitch.operation.ConceptAOperation;
import emfswitch.operation.ConceptBOperation;
import emfswitch.operation.ConceptCOperation;
import emfswitch.operation.ConceptDOperation;
import emfswitch.operation.ConceptEOperation;
import emfswitch.operation.ConceptFOperation;
import emfswitch.operation.ConceptGOperation;
import java.lang.Object;
import java.lang.Override;
import testbidirectionalrelation.ConceptA;
import testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.ConceptG;
import testbidirectionalrelation.util.TestbidirectionalrelationSwitch;

public class SwitchImplementation extends TestbidirectionalrelationSwitch<Object> {
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

	@Override
	public Object caseConceptD(ConceptD it) {
		return new ConceptDOperation(it, this);
	}

	@Override
	public Object caseConceptE(ConceptE it) {
		return new ConceptEOperation(it, this);
	}

	@Override
	public Object caseConceptF(ConceptF it) {
		return new ConceptFOperation(it, this);
	}

	@Override
	public Object caseConceptG(ConceptG it) {
		return new ConceptGOperation(it, this);
	}
}
