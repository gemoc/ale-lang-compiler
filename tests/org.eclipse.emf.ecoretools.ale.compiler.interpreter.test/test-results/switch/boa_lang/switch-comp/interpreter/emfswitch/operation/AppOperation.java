package interpreter.emfswitch.operation;

import boa.App;
import boa.BoaFactory;
import boa.Ctx;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class AppOperation extends ExprOperation {
	private final App it;

	private final InterpreterSwitchImplementation emfswitch;

	public AppOperation(App it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) ctx)));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) ctx)));
		if(vlhs instanceof EvalFunRes) {
			if(vlhs instanceof EvalBoundFunRes) {
				EvalBoundFunRes fct = ((EvalBoundFunRes) (vlhs));
				Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
				execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
				execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
				execboa.MapService.replaceWith(callCtx.getTh(), fct.getTh());
				EvalRes fe = ((EvalRes) (((AppOperation) emfswitch.doSwitch(this.it)).callFunc((EvalBoundFunRes) fct, (Ctx) callCtx)));
				if(fe instanceof EvalFunRes) {
					EvalFunRes fun = ((EvalFunRes) (fe));
					EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					execboa.MapService.replaceWith(tmp.getTh(), fct.getTh());
					result = tmp;
				}
				else {
					result = fe;
				}
			}
			else {
				EvalFunRes fct = ((EvalFunRes) (vlhs));
				Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
				execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
				execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
				execboa.MapService.replaceWith(callCtx.getTh(), ctx.getTh());
				EvalRes fe = ((EvalRes) (((AppOperation) emfswitch.doSwitch(this.it)).callFunc((EvalFunRes) fct, (Ctx) callCtx)));
				if(fe instanceof EvalFunRes) {
					EvalFunRes fun = ((EvalFunRes) (fe));
					EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					execboa.MapService.replaceWith(tmp.getTh(), ctx.getTh());
					result = tmp;
				}
				else {
					result = fe;
				}
			}
		}
		else {
			result = null;
		}
		return result;
	}

	public EvalRes callFunc(EvalFunRes fct, Ctx callCtx) {
		EvalRes result;
		result = ((ExprOperation) emfswitch.doSwitch(fct.getExp())).eval((Ctx) callCtx);
		return result;
	}
}
