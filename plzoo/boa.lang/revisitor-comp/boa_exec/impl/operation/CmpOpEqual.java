package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface CmpOpEqual extends CmpOp {
  EvalRes eval(Ctx ctx);
}
