package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;

public interface CmpOpUnequalOperation extends CmpOpOperation {
	EvalRes eval(Ctx ctx);
}
