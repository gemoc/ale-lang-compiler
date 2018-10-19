package boa_exec.impl.operation;

import boa_dynamic.Ctx;
import boa_dynamic.EvalRes;

public interface Expr extends TopLevelCmd {
  EvalRes eval(Ctx ctx);

  void nextLine(Ctx ctx);
}
