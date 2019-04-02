package test.impl.operation;

import boa.Ctx;
import boa.EvalFunRes;
import boa.EvalMapRes;
import boa.EvalRes;

public interface ProjectOp extends ExprOp {
	EvalRes eval(Ctx ctx);

	EvalRes project(EvalFunRes func, EvalMapRes mvexp);
}
