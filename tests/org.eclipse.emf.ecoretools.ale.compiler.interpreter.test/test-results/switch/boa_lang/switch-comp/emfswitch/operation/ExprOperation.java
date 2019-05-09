package emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Expr;
import emfswitch.SwitchImplementation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class ExprOperation extends TopLevelCmdOperation {
	private final Expr it;

	private final SwitchImplementation emfswitch;

	public ExprOperation(Expr it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		result = null;
		return result;
	}

	public void nextLine(Ctx ctx) {
		LogService.log(execboa.SerializeService.serialize(((emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it)).eval((boa.Ctx) ctx)));
	}
}
