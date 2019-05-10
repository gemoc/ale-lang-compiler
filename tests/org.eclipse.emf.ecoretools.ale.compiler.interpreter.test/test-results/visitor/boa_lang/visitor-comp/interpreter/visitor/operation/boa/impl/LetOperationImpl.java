package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Expr;
import interpreter.boa.visitor.boa.Let;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.ExprOperation;
import interpreter.visitor.operation.boa.LetOperation;

public class LetOperationImpl extends ExprOperationImpl implements LetOperation {
	private final Let it;

	private final VisitorInterface vis;

	public LetOperationImpl(Let it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		Expr lhs = ((Expr) (this.it.getLhs()));
		EvalRes vlhs = ((EvalRes) (((ExprOperation)lhs.accept(vis)).eval((Ctx) (ctx))));
		Ctx nctx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
		execboa.MapService.putAll(nctx.getEnv(), ctx.getEnv());
		execboa.MapService.put(nctx.getEnv(), this.it.getName(), vlhs);
		result = ((ExprOperation)this.it.getRhs().accept(vis)).eval((Ctx) (nctx));
		return result;
	}
}
