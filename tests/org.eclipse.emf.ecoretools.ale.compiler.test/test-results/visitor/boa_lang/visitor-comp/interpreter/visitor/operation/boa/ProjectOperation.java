package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalFunRes;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.EvalRes;

public interface ProjectOperation extends ExprOperation {
	EvalRes eval(Ctx ctx);

	EvalRes project(EvalFunRes func, EvalMapRes mvexp);
}
