package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalMapRes;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.With;
import execboa.MapService;
import org.eclipse.emf.common.util.EMap;
import visitor.VisitorInterface;
import visitor.operation.boa.ExprOperation;
import visitor.operation.boa.WithOperation;

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
				MapService.putAll((EMap) (ret.getValues()), (EMap) (mvlhs.getValues()));
				MapService.putAll((EMap) (ret.getValues()), (EMap) (mvrhs.getValues()));
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
