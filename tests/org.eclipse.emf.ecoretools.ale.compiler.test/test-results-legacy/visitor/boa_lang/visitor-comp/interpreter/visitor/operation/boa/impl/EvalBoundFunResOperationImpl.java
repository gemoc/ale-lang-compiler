package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.EvalBoundFunRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.EvalBoundFunResOperation;

public class EvalBoundFunResOperationImpl extends EvalFunResOperationImpl implements EvalBoundFunResOperation {
	private final EvalBoundFunRes it;

	private final VisitorInterface vis;

	public EvalBoundFunResOperationImpl(EvalBoundFunRes it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
