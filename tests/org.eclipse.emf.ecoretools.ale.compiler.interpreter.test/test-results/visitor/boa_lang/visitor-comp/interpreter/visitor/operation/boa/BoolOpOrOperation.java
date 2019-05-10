package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;

public interface BoolOpOrOperation extends BoolOpOperation {
	EvalRes eval(Ctx ctx);
}
