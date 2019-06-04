package visitor.operation.boa.impl;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.Var;
import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import visitor.VisitorInterface;
import visitor.operation.boa.VarOperation;

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
			result = ((EvalRes) (MapService.getFromMap((EMap) (ctx.getEnv()), (String) (this.it.getName()))));
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}
}
