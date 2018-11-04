package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalFunRes;
import boa.EvalMapRes;
import boa.EvalRes;

public interface Project extends Expr {
  EvalRes eval(Ctx ctx);

  EvalRes project(EvalFunRes func, EvalMapRes mvexp);
}
