package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface CopyOp extends ExprOp {
	EvalRes eval(Ctx ctx);
}
