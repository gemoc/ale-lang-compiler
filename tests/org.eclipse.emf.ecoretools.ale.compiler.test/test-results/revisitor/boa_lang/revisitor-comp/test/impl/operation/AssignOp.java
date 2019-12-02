package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface AssignOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
