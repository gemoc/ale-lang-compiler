package visitor.operation.boa.impl;

import boa.visitor.boa.ArithOpDivide;
import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalIntRes;
import boa.visitor.boa.EvalRes;
import visitor.VisitorInterface;
import visitor.operation.boa.ArithOpDivideOperation;
import visitor.operation.boa.ExprOperation;

public class ArithOpDivideOperationImpl extends ArithOpOperationImpl implements ArithOpDivideOperation {
	private final ArithOpDivide it;

	private final VisitorInterface vis;

	public ArithOpDivideOperationImpl(ArithOpDivide it, VisitorInterface vis) {
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
				ret.setValue((ivlhs.getValue()) / (ivrhs.getValue()));
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
