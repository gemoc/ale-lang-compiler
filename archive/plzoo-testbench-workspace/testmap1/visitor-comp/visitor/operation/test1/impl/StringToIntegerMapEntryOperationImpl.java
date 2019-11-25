package visitor.operation.test1.impl;

import test1.visitor.test1.StringToIntegerMapEntry;
import visitor.VisitorInterface;
import visitor.operation.test1.StringToIntegerMapEntryOperation;

public class StringToIntegerMapEntryOperationImpl implements StringToIntegerMapEntryOperation {
	private final StringToIntegerMapEntry it;

	private final VisitorInterface vis;

	public StringToIntegerMapEntryOperationImpl(StringToIntegerMapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
