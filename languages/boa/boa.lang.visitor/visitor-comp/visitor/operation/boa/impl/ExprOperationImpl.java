package visitor.operation.boa.impl;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.Expr;
import execboa.SerializeService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import visitor.VisitorInterface;
import visitor.operation.boa.ExprOperation;

public abstract class ExprOperationImpl extends TopLevelCmdOperationImpl implements ExprOperation {
	private final Expr it;

	private final VisitorInterface vis;

	public ExprOperationImpl(Expr it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		result = ((EvalRes) (null));
		return result;
	}

	public void nextLine(Ctx ctx) {
		LogService.log(SerializeService.serialize((EvalRes) (((ExprOperation)this.it.accept(vis)).eval((Ctx) (ctx)))));
	}
}
