package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalIntRes;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.Int;
import visitor.VisitorInterface;
import visitor.operation.boa.IntOperation;

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
