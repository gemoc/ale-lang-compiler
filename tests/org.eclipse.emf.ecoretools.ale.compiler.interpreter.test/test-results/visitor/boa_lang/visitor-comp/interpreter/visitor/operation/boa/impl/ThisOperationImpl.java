package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.This;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.ThisOperation;

public class ThisOperationImpl extends ExprOperationImpl implements ThisOperation {
	private final This it;

	private final VisitorInterface vis;

	public ThisOperationImpl(This it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		execboa.MapService.putAll(ret.getValues(), ctx.getTh());
		result = ret;
		return result;
	}
}
