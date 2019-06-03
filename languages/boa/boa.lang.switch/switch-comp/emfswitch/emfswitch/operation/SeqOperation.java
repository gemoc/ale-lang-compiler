package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Seq;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class SeqOperation extends ExprOperation {
	private final Seq it;

	private final EmfswitchSwitchImplementation emfswitch;

	public SeqOperation(Seq it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) (ctx))));
		result = vrhs;
		return result;
	}
}
