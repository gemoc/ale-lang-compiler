package interpreter.visitor.operation.boa.impl;

import execboa.MapService;
import interpreter.boa.visitor.boa.App;
import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalBoundFunRes;
import interpreter.boa.visitor.boa.EvalFunRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.AppOperation;
import interpreter.visitor.operation.boa.ExprOperation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

public class AppOperationImpl extends ExprOperationImpl implements AppOperation {
	private final App it;

	private final VisitorInterface vis;

	public AppOperationImpl(App it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((ExprOperation)this.it.getLhs().accept(vis)).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((ExprOperation)this.it.getRhs().accept(vis)).eval((Ctx) (ctx))));
		if(vlhs instanceof EvalFunRes) {
			if(vlhs instanceof EvalBoundFunRes) {
				EvalBoundFunRes fct = ((EvalBoundFunRes) (vlhs));
				Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
				MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
				MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalRes) (vrhs));
				MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (fct.getTh()));
				EvalRes fe = ((EvalRes) (((AppOperation)this.it.accept(vis)).callFunc((EvalBoundFunRes) (fct), (Ctx) (callCtx))));
				if(fe instanceof EvalFunRes) {
					EvalFunRes fun = ((EvalFunRes) (fe));
					EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (fct.getTh()));
					result = tmp;
				}
				else {
					result = fe;
				}
			}
			else {
				EvalFunRes fct = ((EvalFunRes) (vlhs));
				Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
				MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
				MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalRes) (vrhs));
				MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (ctx.getTh()));
				EvalRes fe = ((EvalRes) (((AppOperation)this.it.accept(vis)).callFunc((EvalFunRes) (fct), (Ctx) (callCtx))));
				if(fe instanceof EvalFunRes) {
					EvalFunRes fun = ((EvalFunRes) (fe));
					EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
					tmp.setExp(fun.getExp());
					tmp.setCtx(fun.getCtx());
					tmp.setName(fun.getName());
					MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (ctx.getTh()));
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
		result = ((ExprOperation)fct.getExp().accept(vis)).eval((Ctx) (callCtx));
		return result;
	}
}
