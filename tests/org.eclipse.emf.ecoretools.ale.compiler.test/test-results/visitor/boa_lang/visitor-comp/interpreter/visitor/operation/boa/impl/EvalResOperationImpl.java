package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.EvalResOperation;

public abstract class EvalResOperationImpl implements EvalResOperation {
	private final EvalRes it;

	private final VisitorInterface vis;

	public EvalResOperationImpl(EvalRes it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
