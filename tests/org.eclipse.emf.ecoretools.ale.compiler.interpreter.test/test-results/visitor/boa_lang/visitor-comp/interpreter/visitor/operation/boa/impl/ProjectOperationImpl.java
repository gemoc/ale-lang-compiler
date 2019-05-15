package interpreter.visitor.operation.boa.impl;

import execboa.MapService;
import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalBoundFunRes;
import interpreter.boa.visitor.boa.EvalFunRes;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.boa.visitor.boa.Project;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.ExprOperation;
import interpreter.visitor.operation.boa.ProjectOperation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

public class ProjectOperationImpl extends ExprOperationImpl implements ProjectOperation {
	private final Project it;

	private final VisitorInterface vis;

	public ProjectOperationImpl(Project it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vexp = ((EvalRes) (((ExprOperation)this.it.getExp().accept(vis)).eval((Ctx) (ctx))));
		if(vexp instanceof EvalMapRes) {
			EvalMapRes mvexp = ((EvalMapRes) (vexp));
			if(MapService.containsKey((EMap) (mvexp.getValues()), (String) (this.it.getName()))) {
				EvalRes x = ((EvalRes) (mvexp.getValues().get((String) (this.it.getName()))));
				if(x instanceof EvalFunRes) {
					EvalFunRes func = ((EvalFunRes) (x));
					result = ((ProjectOperation)this.it.accept(vis)).project((EvalFunRes) (func), (EvalMapRes) (mvexp));
				}
				else {
					result = x;
				}
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

	public EvalRes project(EvalFunRes func, EvalMapRes mvexp) {
		EvalRes result;
		EvalBoundFunRes ret = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
		ret.setExp(func.getExp());
		ret.setCtx(func.getCtx());
		ret.setName(func.getName());
		MapService.replaceWith((EMap) (ret.getTh()), (EMap) (mvexp.getValues()));
		result = ret;
		return result;
	}
}
