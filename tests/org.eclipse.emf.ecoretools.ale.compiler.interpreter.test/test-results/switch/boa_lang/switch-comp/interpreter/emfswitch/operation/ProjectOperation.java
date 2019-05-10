package interpreter.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Project;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class ProjectOperation extends ExprOperation {
	private final Project it;

	private final InterpreterSwitchImplementation emfswitch;

	public ProjectOperation(Project it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vexp = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getExp())).eval((Ctx) (ctx))));
		if(vexp instanceof EvalMapRes) {
			EvalMapRes mvexp = ((EvalMapRes) (vexp));
			if(execboa.MapService.containsKey(mvexp.getValues(), this.it.getName())) {
				EvalRes x = ((EvalRes) (mvexp.getValues().get(this.it.getName())));
				if(x instanceof EvalFunRes) {
					EvalFunRes func = ((EvalFunRes) (x));
					result = ((ProjectOperation) emfswitch.doSwitch(this.it)).project((EvalFunRes) (func), (EvalMapRes) (mvexp));
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
		execboa.MapService.replaceWith(ret.getTh(), mvexp.getValues());
		result = ret;
		return result;
	}
}
