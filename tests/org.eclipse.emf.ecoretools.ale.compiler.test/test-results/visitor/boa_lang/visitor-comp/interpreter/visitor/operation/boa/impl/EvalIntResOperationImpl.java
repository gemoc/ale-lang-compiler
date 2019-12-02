package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.EvalIntRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.EvalIntResOperation;

public class EvalIntResOperationImpl extends EvalResOperationImpl implements EvalIntResOperation {
	private final EvalIntRes it;

	private final VisitorInterface vis;

	public EvalIntResOperationImpl(EvalIntRes it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
