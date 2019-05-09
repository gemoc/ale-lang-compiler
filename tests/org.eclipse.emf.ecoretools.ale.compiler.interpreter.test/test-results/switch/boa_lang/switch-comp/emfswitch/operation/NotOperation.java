package emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalRes;
import boa.Not;
import emfswitch.SwitchImplementation;

public class NotOperation extends ExprOperation {
	private final Not it;

	private final SwitchImplementation emfswitch;

	public NotOperation(Not it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vvalue = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getValue())).eval((Ctx) ctx)));
		if(vvalue instanceof EvalBoolRes) {
			EvalBoolRes bvvalue = ((EvalBoolRes) (vvalue));
			EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
			ret.setValue(!(bvvalue.isValue()));
			result = ret;
		}
		else {
			result = null;
		}
		return result;
	}
}
