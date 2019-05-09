package emfswitch.operation;

import boa.Assign;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import emfswitch.SwitchImplementation;

public class AssignOperation extends ExprOperation {
	private final Assign it;

	private final SwitchImplementation emfswitch;

	public AssignOperation(Assign it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) ctx)));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) ctx)));
		if(vlhs instanceof EvalMapRes) {
			EvalMapRes mvlhs = ((EvalMapRes) (vlhs));
			if(execboa.MapService.containsKey(mvlhs.getValues(), this.it.getName())) {
				execboa.MapService.put(mvlhs.getValues(), this.it.getName(), vrhs);
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
