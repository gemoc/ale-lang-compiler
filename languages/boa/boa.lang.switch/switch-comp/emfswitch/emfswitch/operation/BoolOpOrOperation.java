package emfswitch.emfswitch.operation;

import boa.BoolOpOr;
import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalRes;
import emfswitch.emfswitch.BoaFactory;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class BoolOpOrOperation extends BoolOpOperation {
	private final BoolOpOr it;

	private final EmfswitchSwitchImplementation emfswitch;

	public BoolOpOrOperation(BoolOpOr it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalBoolRes) {
			if(vrhs instanceof EvalBoolRes) {
				EvalBoolRes ivlhs = ((EvalBoolRes) (vlhs));
				EvalBoolRes ivrhs = ((EvalBoolRes) (vrhs));
				EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
				ret.setValue(((ivlhs.isValue()) || (ivrhs.isValue())));
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
