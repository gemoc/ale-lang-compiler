package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Skip;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.SkipOperation;

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
		result = BoaFactory.eINSTANCE.createEvalMapRes();
		return result;
	}
}
