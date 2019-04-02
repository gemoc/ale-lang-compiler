package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface BoolOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
