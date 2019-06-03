package visitor.operation.boa.impl;

import boa.visitor.boa.Field;
import visitor.VisitorInterface;
import visitor.operation.boa.FieldOperation;

public class FieldOperationImpl implements FieldOperation {
	private final Field it;

	private final VisitorInterface vis;

	public FieldOperationImpl(Field it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
