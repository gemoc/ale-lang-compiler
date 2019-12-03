package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.CmpOpLess;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalBoolRes;
import interpreter.boa.visitor.boa.EvalIntRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.CmpOpLessOperation;
import interpreter.visitor.operation.boa.ExprOperation;

public class CmpOpLessOperationImpl extends CmpOpOperationImpl implements CmpOpLessOperation {
	private final CmpOpLess it;

	private final VisitorInterface vis;

	public CmpOpLessOperationImpl(CmpOpLess it, VisitorInterface vis) {
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
				EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
				ret.setValue((ivlhs.getValue()) < (ivrhs.getValue()));
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
