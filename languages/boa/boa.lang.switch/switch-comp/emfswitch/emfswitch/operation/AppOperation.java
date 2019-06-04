package emfswitch.emfswitch.operation;

import boa.App;
import boa.BoaFactory;
import boa.Ctx;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

public class AppOperation extends ExprOperation {
	private final App it;

	private final EmfswitchSwitchImplementation emfswitch;

	public AppOperation(App it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalFunRes) {
			if(vlhs instanceof EvalBoundFunRes) {
				EvalBoundFunRes fct = ((EvalBoundFunRes) (vlhs));
				Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
				MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
				MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalRes) (vrhs));
				MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (fct.getTh()));
				EvalRes fe = ((EvalRes) (((AppOperation) emfswitch.doSwitch(this.it)).callFunc((EvalBoundFunRes) (fct), (Ctx) (callCtx))));
				if(fe instanceof EvalFunRes) {
					EvalFunRes fun = ((EvalFunRes) (fe));
					EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (fct.getTh()));
					result = ((EvalBoundFunRes) (tmp));
				}
				else {
					result = ((EvalRes) (fe));
				}
			}
			else {
				EvalFunRes fct = ((EvalFunRes) (vlhs));
				Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
				MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
				MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalRes) (vrhs));
				MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (ctx.getTh()));
				EvalRes fe = ((EvalRes) (((AppOperation) emfswitch.doSwitch(this.it)).callFunc((EvalFunRes) (fct), (Ctx) (callCtx))));
				if(fe instanceof EvalFunRes) {
					EvalFunRes fun = ((EvalFunRes) (fe));
					EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (ctx.getTh()));
					result = ((EvalBoundFunRes) (tmp));
				}
				else {
					result = ((EvalRes) (fe));
				}
			}
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}

	public EvalRes callFunc(EvalFunRes fct, Ctx callCtx) {
		EvalRes result;
		result = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(fct.getExp())).eval((Ctx) (callCtx))));
		return result;
	}
}
