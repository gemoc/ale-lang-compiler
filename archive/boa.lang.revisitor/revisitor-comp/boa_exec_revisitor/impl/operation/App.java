package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalFunRes;
import boa.EvalRes;

public interface App extends Expr {
  EvalRes eval(Ctx ctx);

  EvalRes callFunc(EvalFunRes fct, Ctx callCtx);
}
