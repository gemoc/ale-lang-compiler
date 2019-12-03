package interpreter.emfswitch.operation;

import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalRes;
import boa.If;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class IfOperation extends ExprOperation {
	private final If it;

	private final InterpreterSwitchImplementation emfswitch;

	public IfOperation(If it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vcond = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getCond())).eval((Ctx) (ctx))));
		if(vcond instanceof EvalBoolRes) {
			EvalBoolRes bvcond = ((EvalBoolRes) (vcond));
			if(bvcond.isValue()) {
				result = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getThn())).eval((Ctx) (ctx))));
			}
			else {
				result = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getEls())).eval((Ctx) (ctx))));
			}
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}
}
