package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.ArithOpTimes;
import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalIntRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.ArithOpTimesOperation;
import interpreter.visitor.operation.boa.ExprOperation;

public class ArithOpTimesOperationImpl extends ArithOpOperationImpl implements ArithOpTimesOperation {
	private final ArithOpTimes it;

	private final VisitorInterface vis;

	public ArithOpTimesOperationImpl(ArithOpTimes it, VisitorInterface vis) {
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
				ret.setValue((ivlhs.getValue()) * (ivrhs.getValue()));
				result = ret;
			}
			else {
				result = null;
			}
		}
		else {
			result = null;
		}
		return result;
	}
}
