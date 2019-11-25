package visitor.visitor.operation.boa;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalFunRes;
import visitor.boa.visitor.boa.EvalRes;

public interface AppOperation extends ExprOperation {
  EvalRes eval(Ctx ctx);

  EvalRes callFunc(EvalFunRes fct, Ctx callCtx);
}
