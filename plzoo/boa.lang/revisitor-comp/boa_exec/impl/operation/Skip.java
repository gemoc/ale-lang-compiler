package boa_exec.impl.operation;

import boa_dynamic.Ctx;
import boa_dynamic.EvalRes;

public interface Skip extends Expr {
  EvalRes eval(Ctx ctx);
}
