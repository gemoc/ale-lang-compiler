package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface ArithOpMinusOp extends ArithOpOp {
	EvalRes eval(Ctx ctx);
}
