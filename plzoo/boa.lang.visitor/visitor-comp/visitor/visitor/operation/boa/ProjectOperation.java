package visitor.visitor.operation.boa;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalFunRes;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.EvalRes;

public interface ProjectOperation extends ExprOperation {
  EvalRes eval(Ctx ctx);

  EvalRes project(EvalFunRes func, EvalMapRes mvexp);
}
