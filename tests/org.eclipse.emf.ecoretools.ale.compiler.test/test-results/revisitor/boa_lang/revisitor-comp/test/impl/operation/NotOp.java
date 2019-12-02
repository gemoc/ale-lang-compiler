package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface NotOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
