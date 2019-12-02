package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalFunRes;
import interpreter.boa.visitor.boa.EvalRes;

public interface AppOperation extends ExprOperation {
	EvalRes eval(Ctx ctx);

	EvalRes callFunc(EvalFunRes fct, Ctx callCtx);
}
