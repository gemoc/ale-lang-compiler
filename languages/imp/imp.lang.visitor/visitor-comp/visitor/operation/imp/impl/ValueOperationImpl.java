package visitor.operation.imp.impl;

import imp.visitor.imp.Value;
import visitor.VisitorInterface;
import visitor.operation.imp.ValueOperation;

public abstract class ValueOperationImpl implements ValueOperation {
	private final Value it;

	private final VisitorInterface vis;

	public ValueOperationImpl(Value it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
