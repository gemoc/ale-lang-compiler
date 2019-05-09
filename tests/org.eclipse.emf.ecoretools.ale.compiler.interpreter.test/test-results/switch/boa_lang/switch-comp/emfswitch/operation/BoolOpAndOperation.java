package emfswitch.operation;

import boa.BoaFactory;
import boa.BoolOpAnd;
import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalRes;
import emfswitch.SwitchImplementation;

public class BoolOpAndOperation extends BoolOpOperation {
	private final BoolOpAnd it;

	private final SwitchImplementation emfswitch;

	public BoolOpAndOperation(BoolOpAnd it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) ctx)));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) ctx)));
		if(vlhs instanceof EvalBoolRes) {
			if(vrhs instanceof EvalBoolRes) {
				EvalBoolRes ivlhs = ((EvalBoolRes) (vlhs));
				EvalBoolRes ivrhs = ((EvalBoolRes) (vrhs));
				EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
				ret.setValue(((ivlhs.isValue()) && (ivrhs.isValue())));
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
