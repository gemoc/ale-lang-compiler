package emfswitch.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalRes;
import boa.Not;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class NotOperation extends ExprOperation {
	private final Not it;

	private final EmfswitchSwitchImplementation emfswitch;

	public NotOperation(Not it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vvalue = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getValue())).eval((Ctx) (ctx))));
		if(vvalue instanceof EvalBoolRes) {
			EvalBoolRes bvvalue = ((EvalBoolRes) (vvalue));
			EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
			ret.setValue(!(bvvalue.isValue()));
			result = ((EvalBoolRes) (ret));
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}
}
