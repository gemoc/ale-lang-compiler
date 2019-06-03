package visitor.operation.boa;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;

public interface CmpOpEqualOperation extends CmpOpOperation {
	EvalRes eval(Ctx ctx);
}
