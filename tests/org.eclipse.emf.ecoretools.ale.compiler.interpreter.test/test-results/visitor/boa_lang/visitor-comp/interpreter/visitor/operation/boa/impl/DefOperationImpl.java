package interpreter.visitor.operation.boa.impl;

import execboa.MapService;
import execboa.SerializeService;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.Def;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.DefOperation;
import interpreter.visitor.operation.boa.ExprOperation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class DefOperationImpl extends TopLevelCmdOperationImpl implements DefOperation {
	private final Def it;

	private final VisitorInterface vis;

	public DefOperationImpl(Def it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public void nextLine(Ctx ctx) {
		EvalRes e = ((EvalRes) (((ExprOperation)this.it.getExpr().accept(vis)).eval((Ctx) (ctx))));
		LogService.log(((this.it.getName()) + (" = ")) + (SerializeService.serialize((EvalRes) (e))));
		MapService.put((EMap) (ctx.getEnv()), (String) (this.it.getName()), (EvalRes) (e));
	}
}
