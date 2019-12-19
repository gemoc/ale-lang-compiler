package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalIntRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Int;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.IntOperation;

public class IntOperationImpl extends ExprOperationImpl implements IntOperation {
	private final Int it;

	private final VisitorInterface vis;

	public IntOperationImpl(Int it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalIntRes ret = ((EvalIntRes) (BoaFactory.eINSTANCE.createEvalIntRes()));
		ret.setValue(this.it.getValue());
		result = ((EvalIntRes) (ret));
		return result;
	}
}
