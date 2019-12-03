package interpreter.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Project;
import execboa.MapService;
import interpreter.emfswitch.InterpreterSwitchImplementation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

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
			if(MapService.containsKey((EMap) (mvexp.getValues()), (String) (this.it.getName()))) {
				EvalRes x = ((EvalRes) (mvexp.getValues().get((String) (this.it.getName()))));
				if(x instanceof EvalFunRes) {
					EvalFunRes func = ((EvalFunRes) (x));
					result = ((EvalRes) (((ProjectOperation) emfswitch.doSwitch(this.it)).project((EvalFunRes) (func), (EvalMapRes) (mvexp))));
				}
				else {
					result = ((EvalRes) (x));
				}
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

	public EvalRes project(EvalFunRes func, EvalMapRes mvexp) {
		EvalRes result;
		EvalBoundFunRes ret = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
		ret.setExp(func.getExp());
		ret.setCtx(func.getCtx());
		ret.setName(func.getName());
		MapService.replaceWith((EMap) (ret.getTh()), (EMap) (mvexp.getValues()));
		result = ((EvalBoundFunRes) (ret));
		return result;
	}
}
