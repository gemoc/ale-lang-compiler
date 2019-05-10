package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.With;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.ExprOperation;
import interpreter.visitor.operation.boa.WithOperation;

public class WithOperationImpl extends ExprOperationImpl implements WithOperation {
	private final With it;

	private final VisitorInterface vis;

	public WithOperationImpl(With it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation)this.it.getLhs().accept(vis)).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation)this.it.getRhs().accept(vis)).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalMapRes) {
			EvalMapRes mvlhs = ((EvalMapRes) (vlhs));
			if(vrhs instanceof EvalMapRes) {
				EvalMapRes mvrhs = ((EvalMapRes) (vrhs));
				EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
				execboa.MapService.putAll(ret.getValues(), mvlhs.getValues());
				execboa.MapService.putAll(ret.getValues(), mvrhs.getValues());
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
