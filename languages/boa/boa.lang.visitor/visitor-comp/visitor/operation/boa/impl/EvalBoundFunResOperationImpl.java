package visitor.operation.boa.impl;

import boa.visitor.boa.EvalBoundFunRes;
import visitor.VisitorInterface;
import visitor.operation.boa.EvalBoundFunResOperation;

public class EvalBoundFunResOperationImpl extends EvalFunResOperationImpl implements EvalBoundFunResOperation {
	private final EvalBoundFunRes it;

	private final VisitorInterface vis;

	public EvalBoundFunResOperationImpl(EvalBoundFunRes it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
