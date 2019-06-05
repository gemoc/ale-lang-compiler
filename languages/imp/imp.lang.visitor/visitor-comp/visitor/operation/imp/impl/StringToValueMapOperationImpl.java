package visitor.operation.imp.impl;

import imp.visitor.imp.StringToValueMap;
import visitor.VisitorInterface;
import visitor.operation.imp.StringToValueMapOperation;

public class StringToValueMapOperationImpl implements StringToValueMapOperation {
	private final StringToValueMap it;

	private final VisitorInterface vis;

	public StringToValueMapOperationImpl(StringToValueMap it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
