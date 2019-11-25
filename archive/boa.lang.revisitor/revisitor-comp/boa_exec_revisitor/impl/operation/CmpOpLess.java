package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface CmpOpLess extends CmpOp {
  EvalRes eval(Ctx ctx);
}
