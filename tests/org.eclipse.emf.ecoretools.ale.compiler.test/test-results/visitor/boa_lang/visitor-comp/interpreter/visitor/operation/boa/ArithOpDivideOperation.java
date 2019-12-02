package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;

public interface ArithOpDivideOperation extends ArithOpOperation {
	EvalRes eval(Ctx ctx);
}
