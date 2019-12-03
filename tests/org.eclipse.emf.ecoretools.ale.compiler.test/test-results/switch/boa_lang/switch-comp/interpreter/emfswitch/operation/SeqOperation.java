package interpreter.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Seq;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class SeqOperation extends ExprOperation {
	private final Seq it;

	private final InterpreterSwitchImplementation emfswitch;

	public SeqOperation(Seq it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) (ctx))));
		result = ((EvalRes) (vrhs));
		return result;
	}
}
