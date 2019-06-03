package visitor.operation.boa.impl;

import boa.visitor.boa.Assign;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalMapRes;
import boa.visitor.boa.EvalRes;
import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import visitor.VisitorInterface;
import visitor.operation.boa.AssignOperation;
import visitor.operation.boa.ExprOperation;

public class AssignOperationImpl extends ExprOperationImpl implements AssignOperation {
	private final Assign it;

	private final VisitorInterface vis;

	public AssignOperationImpl(Assign it, VisitorInterface vis) {
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
			if(MapService.containsKey((EMap) (mvlhs.getValues()), (String) (this.it.getName()))) {
				MapService.put((EMap) (mvlhs.getValues()), (String) (this.it.getName()), (EvalRes) (vrhs));
				result = vrhs;
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
