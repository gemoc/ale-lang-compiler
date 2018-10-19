package boa_exec.impl.operation;

import boa_dynamic.Ctx;
import boa_dynamic.EvalFunRes;
import boa_dynamic.EvalMapRes;
import boa_dynamic.EvalRes;

public interface Project extends Expr {
  EvalRes eval(Ctx ctx);

  EvalRes project(EvalFunRes func, EvalMapRes mvexp);
}
