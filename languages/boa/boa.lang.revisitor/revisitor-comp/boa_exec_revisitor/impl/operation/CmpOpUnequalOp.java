package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface CmpOpUnequalOp extends CmpOpOp {
	EvalRes eval(Ctx ctx);
}
