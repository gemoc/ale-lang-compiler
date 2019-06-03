package visitor.operation.boa;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;

public interface FunOperation extends ExprOperation {
	EvalRes eval(Ctx ctx);
}
