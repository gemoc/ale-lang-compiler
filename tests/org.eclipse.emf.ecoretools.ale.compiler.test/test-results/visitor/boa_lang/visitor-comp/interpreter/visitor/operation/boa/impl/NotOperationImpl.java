package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalBoolRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Not;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.ExprOperation;
import interpreter.visitor.operation.boa.NotOperation;

public class NotOperationImpl extends ExprOperationImpl implements NotOperation {
	private final Not it;

	private final VisitorInterface vis;

	public NotOperationImpl(Not it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vvalue = ((EvalRes) (((ExprOperation)this.it.getValue().accept(vis)).eval((Ctx) (ctx))));
		if(vvalue instanceof EvalBoolRes) {
			EvalBoolRes bvvalue = ((EvalBoolRes) (vvalue));
			EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
			ret.setValue(!(bvvalue.isValue()));
			result = ret;
		}
		else {
			result = null;
		}
		return result;
	}
}
