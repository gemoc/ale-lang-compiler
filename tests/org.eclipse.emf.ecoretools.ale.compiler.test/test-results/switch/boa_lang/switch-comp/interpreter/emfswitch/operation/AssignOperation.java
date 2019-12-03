package interpreter.emfswitch.operation;

import boa.Assign;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import execboa.MapService;
import interpreter.emfswitch.InterpreterSwitchImplementation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

public class AssignOperation extends ExprOperation {
	private final Assign it;

	private final InterpreterSwitchImplementation emfswitch;

	public AssignOperation(Assign it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalMapRes) {
			EvalMapRes mvlhs = ((EvalMapRes) (vlhs));
			if(MapService.containsKey((EMap) (mvlhs.getValues()), (String) (this.it.getName()))) {
				MapService.put((EMap) (mvlhs.getValues()), (String) (this.it.getName()), (EvalRes) (vrhs));
				result = ((EvalRes) (vrhs));
			}
			else {
				result = ((EvalRes) (null));
			}
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}
}
