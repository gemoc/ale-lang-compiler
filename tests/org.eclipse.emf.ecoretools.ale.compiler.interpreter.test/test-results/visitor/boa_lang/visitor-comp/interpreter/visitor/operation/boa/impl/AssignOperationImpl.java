package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.Assign;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.AssignOperation;
import interpreter.visitor.operation.boa.ExprOperation;

public class AssignOperationImpl extends ExprOperationImpl implements AssignOperation {
	private final Assign it;

	private final VisitorInterface vis;

	public AssignOperationImpl(Assign it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation)this.it.getLhs().accept(vis)).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation)this.it.getRhs().accept(vis)).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalMapRes) {
			EvalMapRes mvlhs = ((EvalMapRes) (vlhs));
			if(execboa.MapService.containsKey(mvlhs.getValues(), this.it.getName())) {
				execboa.MapService.put(mvlhs.getValues(), this.it.getName(), vrhs);
				result = vrhs;
			}
			else {
				result = null;
			}
		}
		else {
			result = null;
		}
		return result;
	}
}
