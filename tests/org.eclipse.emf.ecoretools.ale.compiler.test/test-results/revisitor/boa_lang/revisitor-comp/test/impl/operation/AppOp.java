package test.impl.operation;

import boa.Ctx;
import boa.EvalFunRes;
import boa.EvalRes;

public interface AppOp extends ExprOp {
	EvalRes eval(Ctx ctx);

	EvalRes callFunc(EvalFunRes fct, Ctx callCtx);
}
