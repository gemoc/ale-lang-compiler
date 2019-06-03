package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Var;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

public class VarOperation extends ExprOperation {
	private final Var it;

	private final EmfswitchSwitchImplementation emfswitch;

	public VarOperation(Var it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		if(MapService.containsKey((EMap) (ctx.getEnv()), (String) (this.it.getName()))) {
			result = MapService.getFromMap((EMap) (ctx.getEnv()), (String) (this.it.getName()));
		}
		else {
			result = null;
		}
		return result;
	}
}
