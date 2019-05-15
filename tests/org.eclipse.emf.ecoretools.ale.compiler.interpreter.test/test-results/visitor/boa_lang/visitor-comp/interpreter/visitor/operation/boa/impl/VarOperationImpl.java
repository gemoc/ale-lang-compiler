package interpreter.visitor.operation.boa.impl;

import execboa.MapService;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Var;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.VarOperation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

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
		if(MapService.containsKey((EMap) (ctx.getEnv()), (String) (this.it.getName()))) {
			result = MapService.getFromMap((EMap) (ctx.getEnv()), (String) (this.it.getName()));
		}
		else {
			result = null;
		}
		return result;
	}
}
