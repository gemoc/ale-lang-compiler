package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.Field;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.FieldOperation;

public class FieldOperationImpl implements FieldOperation {
	private final Field it;

	private final VisitorInterface vis;

	public FieldOperationImpl(Field it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
