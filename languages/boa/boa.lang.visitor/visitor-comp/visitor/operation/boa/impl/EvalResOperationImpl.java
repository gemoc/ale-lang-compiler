package visitor.operation.boa.impl;

import boa.visitor.boa.EvalRes;
import visitor.VisitorInterface;
import visitor.operation.boa.EvalResOperation;

public abstract class EvalResOperationImpl implements EvalResOperation {
	private final EvalRes it;

	private final VisitorInterface vis;

	public EvalResOperationImpl(EvalRes it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
