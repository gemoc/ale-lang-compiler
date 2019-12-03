package interpreter.emfswitch.operation;

import boa.BoaFactory;
import boa.CmpOpEqual;
import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalIntRes;
import boa.EvalRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class CmpOpEqualOperation extends CmpOpOperation {
	private final CmpOpEqual it;

	private final InterpreterSwitchImplementation emfswitch;

	public CmpOpEqualOperation(CmpOpEqual it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalIntRes) {
			if(vrhs instanceof EvalIntRes) {
				EvalIntRes ivlhs = ((EvalIntRes) (vlhs));
				EvalIntRes ivrhs = ((EvalIntRes) (vrhs));
				EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
				ret.setValue(EqualService.equals((ivlhs.getValue()), (ivrhs.getValue())));
				result = ((EvalBoolRes) (ret));
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
