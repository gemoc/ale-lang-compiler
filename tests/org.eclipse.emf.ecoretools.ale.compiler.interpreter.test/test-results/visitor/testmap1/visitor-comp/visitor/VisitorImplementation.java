package visitor;

import test1.visitor.test1.ConceptA;
import test1.visitor.test1.StringToIntegerMapEntry;
import visitor.operation.test1.ConceptAOperation;
import visitor.operation.test1.StringToIntegerMapEntryOperation;
import visitor.operation.test1.impl.ConceptAOperationImpl;
import visitor.operation.test1.impl.StringToIntegerMapEntryOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public ConceptAOperation visittest1__ConceptA(ConceptA it) {
		return new ConceptAOperationImpl(it, this);
	}

	public StringToIntegerMapEntryOperation visittest1__StringToIntegerMapEntry(
			StringToIntegerMapEntry it) {
		return new StringToIntegerMapEntryOperationImpl(it, this);
	}
}
