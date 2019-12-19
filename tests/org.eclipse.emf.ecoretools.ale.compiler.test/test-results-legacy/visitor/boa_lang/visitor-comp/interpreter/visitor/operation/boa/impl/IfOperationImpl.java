package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalBoolRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.If;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.ExprOperation;
import interpreter.visitor.operation.boa.IfOperation;

public class IfOperationImpl extends ExprOperationImpl implements IfOperation {
	private final If it;

	private final VisitorInterface vis;

	public IfOperationImpl(If it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vcond = ((EvalRes) (((ExprOperation)this.it.getCond().accept(vis)).eval((Ctx) (ctx))));
		if(vcond instanceof EvalBoolRes) {
			EvalBoolRes bvcond = ((EvalBoolRes) (vcond));
			if(bvcond.isValue()) {
				result = ((EvalRes) (((ExprOperation)this.it.getThn().accept(vis)).eval((Ctx) (ctx))));
			}
			else {
				result = ((EvalRes) (((ExprOperation)this.it.getEls().accept(vis)).eval((Ctx) (ctx))));
			}
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}
}
