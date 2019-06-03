package emfswitch.emfswitch.operation;

import boa.ArithOpPlus;
import boa.BoaFactory;
import boa.Ctx;
import boa.EvalIntRes;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class ArithOpPlusOperation extends ArithOpOperation {
	private final ArithOpPlus it;

	private final EmfswitchSwitchImplementation emfswitch;

	public ArithOpPlusOperation(ArithOpPlus it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalIntRes) {
			if(vrhs instanceof EvalIntRes) {
				EvalIntRes ivlhs = ((EvalIntRes) (vlhs));
				EvalIntRes ivrhs = ((EvalIntRes) (vrhs));
				EvalIntRes ret = ((EvalIntRes) (BoaFactory.eINSTANCE.createEvalIntRes()));
				ret.setValue((ivlhs.getValue()) + (ivrhs.getValue()));
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
