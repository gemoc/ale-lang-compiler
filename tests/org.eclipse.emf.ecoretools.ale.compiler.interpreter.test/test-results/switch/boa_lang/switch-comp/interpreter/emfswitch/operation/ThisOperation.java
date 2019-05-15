package interpreter.emfswitch.operation;

import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.This;
import execboa.MapService;
import interpreter.emfswitch.BoaFactory;
import interpreter.emfswitch.InterpreterSwitchImplementation;
import org.eclipse.emf.common.util.EMap;

public class ThisOperation extends ExprOperation {
	private final This it;

	private final InterpreterSwitchImplementation emfswitch;

	public ThisOperation(This it, InterpreterSwitchImplementation emfswitch) {
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
