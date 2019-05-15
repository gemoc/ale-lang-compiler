package interpreter.visitor.operation.boa.impl;

import execboa.MapService;
import interpreter.boa.visitor.boa.Assign;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.AssignOperation;
import interpreter.visitor.operation.boa.ExprOperation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

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
