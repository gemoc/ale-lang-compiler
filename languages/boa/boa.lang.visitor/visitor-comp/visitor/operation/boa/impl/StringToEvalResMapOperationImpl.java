package visitor.operation.boa.impl;

import boa.visitor.boa.StringToEvalResMap;
import visitor.VisitorInterface;
import visitor.operation.boa.StringToEvalResMapOperation;

public class StringToEvalResMapOperationImpl implements StringToEvalResMapOperation {
	private final StringToEvalResMap it;

	private final VisitorInterface vis;

	public StringToEvalResMapOperationImpl(StringToEvalResMap it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
