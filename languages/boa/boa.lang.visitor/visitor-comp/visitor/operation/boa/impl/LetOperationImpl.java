package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.Expr;
import boa.visitor.boa.Let;
import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import visitor.VisitorInterface;
import visitor.operation.boa.ExprOperation;
import visitor.operation.boa.LetOperation;

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
		MapService.putAll((EMap) (nctx.getEnv()), (EMap) (ctx.getEnv()));
		MapService.put((EMap) (nctx.getEnv()), (String) (this.it.getName()), (EvalRes) (vlhs));
		result = ((EvalRes) (((ExprOperation)this.it.getRhs().accept(vis)).eval((Ctx) (nctx))));
		return result;
	}
}
