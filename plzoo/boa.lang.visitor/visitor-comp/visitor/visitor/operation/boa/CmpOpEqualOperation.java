package visitor.visitor.operation.boa;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;

public interface CmpOpEqualOperation extends CmpOpOperation {
  EvalRes eval(Ctx ctx);
}
