package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface CmpOpEqualOp extends CmpOpOp {
	EvalRes eval(Ctx ctx);
}
