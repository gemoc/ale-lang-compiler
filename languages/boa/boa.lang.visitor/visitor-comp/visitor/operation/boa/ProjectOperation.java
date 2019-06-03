package visitor.operation.boa;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalFunRes;
import boa.visitor.boa.EvalMapRes;
import boa.visitor.boa.EvalRes;

public interface ProjectOperation extends ExprOperation {
	EvalRes eval(Ctx ctx);

	EvalRes project(EvalFunRes func, EvalMapRes mvexp);
}
