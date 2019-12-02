package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface WithOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
