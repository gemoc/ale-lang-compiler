package visitor.visitor.operation.boa;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;

public interface BoolOpAndOperation extends BoolOpOperation {
  EvalRes eval(Ctx ctx);
}
