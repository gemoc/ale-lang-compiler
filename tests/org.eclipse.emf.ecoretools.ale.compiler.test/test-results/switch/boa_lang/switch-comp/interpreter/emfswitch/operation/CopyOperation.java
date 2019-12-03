package interpreter.emfswitch.operation;

import boa.BoaFactory;
import boa.Copy;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import execboa.MapService;
import interpreter.emfswitch.InterpreterSwitchImplementation;
import org.eclipse.emf.common.util.EMap;

public class CopyOperation extends ExprOperation {
	private final Copy it;

	private final InterpreterSwitchImplementation emfswitch;

	public CopyOperation(Copy it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vcopy = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getCopy())).eval((Ctx) (ctx))));
		if(vcopy instanceof EvalMapRes) {
			EvalMapRes mvcopy = ((EvalMapRes) (vcopy));
			EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
			MapService.putAll((EMap) (ret.getValues()), (EMap) (mvcopy.getValues()));
			result = ((EvalMapRes) (ret));
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}
}
