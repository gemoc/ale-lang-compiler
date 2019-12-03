package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Bool;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalBoolRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.BoolOperation;

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
