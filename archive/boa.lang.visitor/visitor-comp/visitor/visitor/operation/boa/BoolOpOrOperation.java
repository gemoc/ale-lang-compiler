package visitor.visitor.operation.boa;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;

public interface BoolOpOrOperation extends BoolOpOperation {
  EvalRes eval(Ctx ctx);
}
