package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.This;
import emfswitch.emfswitch.BoaFactory;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import execboa.MapService;
import org.eclipse.emf.common.util.EMap;

public class ThisOperation extends ExprOperation {
	private final This it;

	private final EmfswitchSwitchImplementation emfswitch;

	public ThisOperation(This it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		MapService.putAll((EMap) (ret.getValues()), (EMap) (ctx.getTh()));
		result = ret;
		return result;
	}
}
