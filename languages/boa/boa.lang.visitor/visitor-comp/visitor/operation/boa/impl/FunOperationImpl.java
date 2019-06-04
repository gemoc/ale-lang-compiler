package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalFunRes;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.Fun;
import visitor.VisitorInterface;
import visitor.operation.boa.FunOperation;

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
