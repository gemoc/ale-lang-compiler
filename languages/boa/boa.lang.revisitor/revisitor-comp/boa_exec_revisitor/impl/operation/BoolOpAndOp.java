package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface BoolOpAndOp extends BoolOpOp {
	EvalRes eval(Ctx ctx);
}
