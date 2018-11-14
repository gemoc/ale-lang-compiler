package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface CmpOpEqual extends CmpOp {
  EvalRes eval(Ctx ctx);
}
