package interpreter.emfswitch.operation;

import boa.Ctx;
import boa.Def;
import boa.EvalRes;
import execboa.MapService;
import execboa.SerializeService;
import interpreter.emfswitch.InterpreterSwitchImplementation;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class DefOperation extends TopLevelCmdOperation {
	private final Def it;

	private final InterpreterSwitchImplementation emfswitch;

	public DefOperation(Def it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void nextLine(Ctx ctx) {
		EvalRes e = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getExpr())).eval((Ctx) (ctx))));
		LogService.log(((this.it.getName()) + (" = ")) + (SerializeService.serialize((EvalRes) (e))));
		MapService.put((EMap) (ctx.getEnv()), (String) (this.it.getName()), (EvalRes) (e));
	}
}
