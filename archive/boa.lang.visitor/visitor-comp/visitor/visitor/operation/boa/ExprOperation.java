package visitor.visitor.operation.boa;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;

public interface ExprOperation extends TopLevelCmdOperation {
  EvalRes eval(Ctx ctx);

  void nextLine(Ctx ctx);
}
