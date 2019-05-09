package emfswitch.operation;

import boa.Ctx;
import boa.Def;
import boa.EvalRes;
import emfswitch.SwitchImplementation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class DefOperation extends TopLevelCmdOperation {
	private final Def it;

	private final SwitchImplementation emfswitch;

	public DefOperation(Def it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void nextLine(Ctx ctx) {
		EvalRes e = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it.getExpr())).eval((Ctx) ctx)));
		LogService.log(((this.it.getName()) + (" = ")) + (execboa.SerializeService.serialize(e)));
		execboa.MapService.put(ctx.getEnv(), this.it.getName(), e);
	}
}
