package emfswitch.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalRes;
import boa.Expr;
import boa.Let;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

public class LetOperation extends ExprOperation {
	private final Let it;

	private final EmfswitchSwitchImplementation emfswitch;

	public LetOperation(Let it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		Expr lhs = ((Expr) (this.it.getLhs()));
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(lhs)).eval((Ctx) (ctx))));
		Ctx nctx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
		MapService.putAll((EMap) (nctx.getEnv()), (EMap) (ctx.getEnv()));
		MapService.put((EMap) (nctx.getEnv()), (String) (this.it.getName()), (EvalRes) (vlhs));
		result = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) (nctx))));
		return result;
	}
}
