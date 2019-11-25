package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface Expr extends TopLevelCmd {
  EvalRes eval(Ctx ctx);

  void nextLine(Ctx ctx);
}
