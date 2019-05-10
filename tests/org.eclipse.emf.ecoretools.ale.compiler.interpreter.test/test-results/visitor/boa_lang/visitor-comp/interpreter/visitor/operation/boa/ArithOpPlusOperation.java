package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;

public interface ArithOpPlusOperation extends ArithOpOperation {
	EvalRes eval(Ctx ctx);
}
