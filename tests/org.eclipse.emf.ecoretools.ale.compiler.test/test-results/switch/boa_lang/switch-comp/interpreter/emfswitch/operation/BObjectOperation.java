package interpreter.emfswitch.operation;

import boa.BObject;
import boa.BoaFactory;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Field;
import execboa.MapService;
import interpreter.emfswitch.InterpreterSwitchImplementation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

public class BObjectOperation extends ExprOperation {
	private final BObject it;

	private final InterpreterSwitchImplementation emfswitch;

	public BObjectOperation(BObject it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		for (Field x: this.it.getFields()) {
			EvalRes v = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(x.getValue())).eval((Ctx) (ctx))));
			MapService.put((EMap) (ret.getValues()), (String) (x.getName()), (EvalRes) (v));
		}
		result = ((EvalMapRes) (ret));
		return result;
	}
}
