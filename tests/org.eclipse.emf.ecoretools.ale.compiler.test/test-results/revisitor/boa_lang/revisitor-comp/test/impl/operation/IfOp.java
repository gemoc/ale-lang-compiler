package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface IfOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
