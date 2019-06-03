package visitor.operation.boa.impl;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalBoolRes;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.If;
import visitor.VisitorInterface;
import visitor.operation.boa.ExprOperation;
import visitor.operation.boa.IfOperation;

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
				result = ((ExprOperation)this.it.getThn().accept(vis)).eval((Ctx) (ctx));
			}
			else {
				result = ((ExprOperation)this.it.getEls().accept(vis)).eval((Ctx) (ctx));
			}
		}
		else {
			result = null;
		}
		return result;
	}
}
