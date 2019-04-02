package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface ThisOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
