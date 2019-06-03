package visitor.operation.boa;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;

public interface BoolOpOrOperation extends BoolOpOperation {
	EvalRes eval(Ctx ctx);
}
