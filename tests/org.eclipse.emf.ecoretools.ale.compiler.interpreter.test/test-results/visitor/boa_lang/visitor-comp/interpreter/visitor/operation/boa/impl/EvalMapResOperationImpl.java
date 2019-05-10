package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.EvalMapResOperation;

public class EvalMapResOperationImpl extends EvalResOperationImpl implements EvalMapResOperation {
	private final EvalMapRes it;

	private final VisitorInterface vis;

	public EvalMapResOperationImpl(EvalMapRes it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
