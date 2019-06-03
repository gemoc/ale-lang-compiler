package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.BoolOpOr;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalBoolRes;
import boa.visitor.boa.EvalRes;
import visitor.VisitorInterface;
import visitor.operation.boa.BoolOpOrOperation;
import visitor.operation.boa.ExprOperation;

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
