package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalMapRes;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.Skip;
import visitor.VisitorInterface;
import visitor.operation.boa.SkipOperation;

public class SkipOperationImpl extends ExprOperationImpl implements SkipOperation {
	private final Skip it;

	private final VisitorInterface vis;

	public SkipOperationImpl(Skip it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		result = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		return result;
	}
}
