package interpreter.emfswitch.operation;

import boa.ArithOpDivide;
import boa.BoaFactory;
import boa.Ctx;
import boa.EvalIntRes;
import boa.EvalRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class ArithOpDivideOperation extends ArithOpOperation {
	private final ArithOpDivide it;

	private final InterpreterSwitchImplementation emfswitch;

	public ArithOpDivideOperation(ArithOpDivide it, InterpreterSwitchImplementation emfswitch) {
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
				EvalIntRes ret = ((EvalIntRes) (BoaFactory.eINSTANCE.createEvalIntRes()));
				ret.setValue((ivlhs.getValue()) / (ivrhs.getValue()));
				result = ((EvalIntRes) (ret));
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
