package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;

public interface ExprOperation extends TopLevelCmdOperation {
	EvalRes eval(Ctx ctx);

	void nextLine(Ctx ctx);
}
