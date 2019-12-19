package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalRes;

public interface ArithOpTimesOperation extends ArithOpOperation {
	EvalRes eval(Ctx ctx);
}
