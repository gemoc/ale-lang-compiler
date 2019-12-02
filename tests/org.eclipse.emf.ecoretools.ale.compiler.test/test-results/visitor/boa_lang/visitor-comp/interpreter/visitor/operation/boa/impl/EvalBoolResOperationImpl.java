package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.EvalBoolRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.EvalBoolResOperation;

public class EvalBoolResOperationImpl extends EvalResOperationImpl implements EvalBoolResOperation {
	private final EvalBoolRes it;

	private final VisitorInterface vis;

	public EvalBoolResOperationImpl(EvalBoolRes it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
