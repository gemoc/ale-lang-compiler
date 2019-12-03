package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.BoolOpOr;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalBoolRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.BoolOpOrOperation;
import interpreter.visitor.operation.boa.ExprOperation;

public class BoolOpOrOperationImpl extends BoolOpOperationImpl implements BoolOpOrOperation {
	private final BoolOpOr it;

	private final VisitorInterface vis;

	public BoolOpOrOperationImpl(BoolOpOr it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation)this.it.getLhs().accept(vis)).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation)this.it.getRhs().accept(vis)).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalBoolRes) {
			if(vrhs instanceof EvalBoolRes) {
				EvalBoolRes ivlhs = ((EvalBoolRes) (vlhs));
				EvalBoolRes ivrhs = ((EvalBoolRes) (vrhs));
				EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
				ret.setValue(((ivlhs.isValue()) || (ivrhs.isValue())));
				result = ((EvalBoolRes) (ret));
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
