package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface CmpOpLess extends CmpOp {
  EvalRes eval(Ctx ctx);
}
