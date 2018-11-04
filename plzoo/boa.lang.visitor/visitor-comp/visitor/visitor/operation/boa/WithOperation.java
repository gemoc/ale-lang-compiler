package visitor.visitor.operation.boa;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;

public interface WithOperation extends ExprOperation {
  EvalRes eval(Ctx ctx);
}
