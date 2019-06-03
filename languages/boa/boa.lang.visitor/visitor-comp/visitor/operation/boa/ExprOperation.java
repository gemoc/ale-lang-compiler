package visitor.operation.boa;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;

public interface ExprOperation extends TopLevelCmdOperation {
	EvalRes eval(Ctx ctx);

	void nextLine(Ctx ctx);
}
