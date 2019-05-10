package interpreter.visitor.operation.boa.impl;

import execboa.SerializeService;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Expr;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.ExprOperation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

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
		result = null;
		return result;
	}

	public void nextLine(Ctx ctx) {
		LogService.log(SerializeService.serialize(((ExprOperation)this.it.accept(vis)).eval((Ctx) (ctx))));
	}
}
