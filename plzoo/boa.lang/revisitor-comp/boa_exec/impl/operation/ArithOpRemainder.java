package boa_exec.impl.operation;

import boa_dynamic.Ctx;
import boa_dynamic.EvalRes;

public interface ArithOpRemainder extends ArithOp {
  EvalRes eval(Ctx ctx);
}
