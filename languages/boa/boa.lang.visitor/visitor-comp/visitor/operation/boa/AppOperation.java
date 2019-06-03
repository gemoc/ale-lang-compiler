package visitor.operation.boa;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalFunRes;
import boa.visitor.boa.EvalRes;

public interface AppOperation extends ExprOperation {
	EvalRes eval(Ctx ctx);

	EvalRes callFunc(EvalFunRes fct, Ctx callCtx);
}
