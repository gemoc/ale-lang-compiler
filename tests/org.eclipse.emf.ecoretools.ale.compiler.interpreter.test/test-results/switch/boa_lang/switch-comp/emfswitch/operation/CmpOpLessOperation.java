package emfswitch.operation;

import boa.BoaFactory;
import boa.CmpOpLess;
import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalIntRes;
import boa.EvalRes;
import emfswitch.SwitchImplementation;

public class CmpOpLessOperation extends CmpOpOperation {
	private final CmpOpLess it;

	private final SwitchImplementation emfswitch;

	public CmpOpLessOperation(CmpOpLess it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) ctx)));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) ctx)));
		if(vlhs instanceof EvalIntRes) {
			if(vrhs instanceof EvalIntRes) {
				EvalIntRes ivlhs = ((EvalIntRes) (vlhs));
				EvalIntRes ivrhs = ((EvalIntRes) (vrhs));
				EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
				ret.setValue((ivlhs.getValue()) < (ivrhs.getValue()));
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
