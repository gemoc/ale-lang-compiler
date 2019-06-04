package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Bool;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalBoolRes;
import boa.visitor.boa.EvalRes;
import visitor.VisitorInterface;
import visitor.operation.boa.BoolOperation;

public class BoolOperationImpl extends ExprOperationImpl implements BoolOperation {
	private final Bool it;

	private final VisitorInterface vis;

	public BoolOperationImpl(Bool it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
		ret.setValue(this.it.isValue());
		result = ((EvalBoolRes) (ret));
		return result;
	}
}
