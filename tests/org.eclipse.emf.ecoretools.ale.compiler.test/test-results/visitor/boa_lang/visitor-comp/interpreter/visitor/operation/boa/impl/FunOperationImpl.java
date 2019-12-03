package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalFunRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Fun;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.FunOperation;

public class FunOperationImpl extends ExprOperationImpl implements FunOperation {
	private final Fun it;

	private final VisitorInterface vis;

	public FunOperationImpl(Fun it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalFunRes ret = ((EvalFunRes) (BoaFactory.eINSTANCE.createEvalFunRes()));
		ret.setExp(this.it.getBody());
		ret.setCtx(ctx);
		ret.setName(this.it.getName());
		result = ((EvalFunRes) (ret));
		return result;
	}
}
