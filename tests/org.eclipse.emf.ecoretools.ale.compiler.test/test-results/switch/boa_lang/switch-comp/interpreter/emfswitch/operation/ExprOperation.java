package interpreter.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Expr;
import execboa.SerializeService;
import interpreter.emfswitch.InterpreterSwitchImplementation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class ExprOperation extends TopLevelCmdOperation {
	private final Expr it;

	private final InterpreterSwitchImplementation emfswitch;

	public ExprOperation(Expr it, InterpreterSwitchImplementation emfswitch) {
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
		LogService.log(SerializeService.serialize((EvalRes) (((ExprOperation) emfswitch.doSwitch(this.it)).eval((Ctx) (ctx)))));
	}
}
