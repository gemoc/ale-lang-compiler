package interpreter.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.With;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class WithOperation extends ExprOperation {
	private final With it;

	private final InterpreterSwitchImplementation emfswitch;

	public WithOperation(With it, InterpreterSwitchImplementation emfswitch) {
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
