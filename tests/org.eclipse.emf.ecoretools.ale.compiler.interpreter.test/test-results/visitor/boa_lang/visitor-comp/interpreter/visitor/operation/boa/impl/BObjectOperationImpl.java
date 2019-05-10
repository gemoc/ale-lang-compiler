package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BObject;
import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Field;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.BObjectOperation;
import interpreter.visitor.operation.boa.ExprOperation;

public class BObjectOperationImpl extends ExprOperationImpl implements BObjectOperation {
	private final BObject it;

	private final VisitorInterface vis;

	public BObjectOperationImpl(BObject it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		for(Field x: this.it.getFields()) {
			EvalRes v = ((EvalRes) (((ExprOperation)x.getValue().accept(vis)).eval((Ctx) (ctx))));
			execboa.MapService.put(ret.getValues(), x.getName(), v);
		}
		result = ret;
		return result;
	}
}
