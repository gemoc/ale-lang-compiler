package test.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface SeqOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
