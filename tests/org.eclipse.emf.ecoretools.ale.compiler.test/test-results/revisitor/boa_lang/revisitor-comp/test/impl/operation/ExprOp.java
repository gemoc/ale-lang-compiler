package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface ExprOp extends TopLevelCmdOp {
	EvalRes eval(Ctx ctx);

	void nextLine(Ctx ctx);
}
