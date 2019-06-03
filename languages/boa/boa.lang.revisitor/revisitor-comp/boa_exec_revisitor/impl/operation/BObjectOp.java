package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface BObjectOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
