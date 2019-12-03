package interpreter.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Var;
import execboa.MapService;
import interpreter.emfswitch.InterpreterSwitchImplementation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

public class VarOperation extends ExprOperation {
	private final Var it;

	private final InterpreterSwitchImplementation emfswitch;

	public VarOperation(Var it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		if(MapService.containsKey((EMap) (ctx.getEnv()), (String) (this.it.getName()))) {
			result = ((EvalRes) (MapService.getFromMap((EMap) (ctx.getEnv()), (String) (this.it.getName()))));
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}
}
