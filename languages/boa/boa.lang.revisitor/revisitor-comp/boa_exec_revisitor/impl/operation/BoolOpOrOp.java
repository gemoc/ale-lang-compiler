package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface BoolOpOrOp extends BoolOpOp {
	EvalRes eval(Ctx ctx);
}
