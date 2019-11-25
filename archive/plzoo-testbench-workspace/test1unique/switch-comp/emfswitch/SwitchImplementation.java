package emfswitch;

import emfswitch.operation.ConceptAOperation;
import java.lang.Object;
import java.lang.Override;
import test1.ConceptA;
import test1.util.Test1uniqueSwitch;

public class SwitchImplementation extends Test1uniqueSwitch<Object> {
	@Override
	public Object caseConceptA(ConceptA it) {
		return new ConceptAOperation(it, this);
	}
}
