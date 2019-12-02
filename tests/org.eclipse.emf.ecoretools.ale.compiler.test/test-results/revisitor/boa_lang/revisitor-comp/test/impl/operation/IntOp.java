package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface IntOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
