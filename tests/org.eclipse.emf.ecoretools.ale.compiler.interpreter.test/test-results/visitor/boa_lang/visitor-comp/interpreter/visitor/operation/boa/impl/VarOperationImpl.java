package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Var;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.VarOperation;

public class VarOperationImpl extends ExprOperationImpl implements VarOperation {
	private final Var it;

	private final VisitorInterface vis;

	public VarOperationImpl(Var it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		if(execboa.MapService.containsKey(ctx.getEnv(), this.it.getName())) {
			result = execboa.MapService.getFromMap(ctx.getEnv(), this.it.getName());
		}
		else {
			result = null;
		}
		return result;
	}
}
