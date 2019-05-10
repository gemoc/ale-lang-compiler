package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.StringToEvalResMap;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.StringToEvalResMapOperation;

public class StringToEvalResMapOperationImpl implements StringToEvalResMapOperation {
	private final StringToEvalResMap it;

	private final VisitorInterface vis;

	public StringToEvalResMapOperationImpl(StringToEvalResMap it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
