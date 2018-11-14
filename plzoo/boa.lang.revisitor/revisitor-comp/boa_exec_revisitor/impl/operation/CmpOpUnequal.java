package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface CmpOpUnequal extends CmpOp {
  EvalRes eval(Ctx ctx);
}
