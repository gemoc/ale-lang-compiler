package visitor.operation.boa.impl;

import boa.visitor.boa.EvalFunRes;
import visitor.VisitorInterface;
import visitor.operation.boa.EvalFunResOperation;

public class EvalFunResOperationImpl extends EvalResOperationImpl implements EvalFunResOperation {
	private final EvalFunRes it;

	private final VisitorInterface vis;

	public EvalFunResOperationImpl(EvalFunRes it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
