package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalMapRes;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.This;
import execboa.MapService;
import org.eclipse.emf.common.util.EMap;
import visitor.VisitorInterface;
import visitor.operation.boa.ThisOperation;

public class ThisOperationImpl extends ExprOperationImpl implements ThisOperation {
	private final This it;

	private final VisitorInterface vis;

	public ThisOperationImpl(This it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		MapService.putAll((EMap) (ret.getValues()), (EMap) (ctx.getTh()));
		result = ret;
		return result;
	}
}
