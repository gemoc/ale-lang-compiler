package emfswitch;

import emfswitch.operation.ConceptAOperation;
import java.lang.Object;
import java.lang.Override;
import test1unique.ConceptA;
import test1unique.util.Test1Switch;

public class SwitchImplementation extends Test1Switch<Object> {
	@Override
	public Object caseConceptA(ConceptA it) {
		return new ConceptAOperation(it, this);
	}
}
