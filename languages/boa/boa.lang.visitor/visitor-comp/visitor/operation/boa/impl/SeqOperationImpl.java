package visitor.operation.boa.impl;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.Seq;
import visitor.VisitorInterface;
import visitor.operation.boa.ExprOperation;
import visitor.operation.boa.SeqOperation;

public class SeqOperationImpl extends ExprOperationImpl implements SeqOperation {
	private final Seq it;

	private final VisitorInterface vis;

	public SeqOperationImpl(Seq it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation)this.it.getLhs().accept(vis)).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation)this.it.getRhs().accept(vis)).eval((Ctx) (ctx))));
		result = vrhs;
		return result;
	}
}
