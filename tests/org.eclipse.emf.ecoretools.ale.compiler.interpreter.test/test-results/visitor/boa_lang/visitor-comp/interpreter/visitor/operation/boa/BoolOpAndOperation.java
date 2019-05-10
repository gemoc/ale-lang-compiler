package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;

public interface BoolOpAndOperation extends BoolOpOperation {
	EvalRes eval(Ctx ctx);
}
