package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface SkipOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
