package visitor.operation.boa.impl;

import boa.visitor.boa.ArithOpRemainder;
import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalIntRes;
import boa.visitor.boa.EvalRes;
import execboa.MathService;
import visitor.VisitorInterface;
import visitor.operation.boa.ArithOpRemainderOperation;
import visitor.operation.boa.ExprOperation;

public class ArithOpRemainderOperationImpl extends ArithOpOperationImpl implements ArithOpRemainderOperation {
	private final ArithOpRemainder it;

	private final VisitorInterface vis;

	public ArithOpRemainderOperationImpl(ArithOpRemainder it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation)this.it.getLhs().accept(vis)).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation)this.it.getRhs().accept(vis)).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalIntRes) {
			if(vrhs instanceof EvalIntRes) {
				EvalIntRes ivlhs = ((EvalIntRes) (vlhs));
				EvalIntRes ivrhs = ((EvalIntRes) (vrhs));
				EvalIntRes ret = ((EvalIntRes) (BoaFactory.eINSTANCE.createEvalIntRes()));
				ret.setValue(MathService.mod((ArithOpRemainder) (this.it), (int) (ivlhs.getValue()), (int) (ivrhs.getValue())));
				result = ((EvalIntRes) (ret));
			}
			else {
				result = ((EvalRes) (null));
			}
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}
}
