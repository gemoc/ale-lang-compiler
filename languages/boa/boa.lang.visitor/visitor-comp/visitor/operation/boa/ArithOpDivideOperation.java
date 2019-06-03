package visitor.operation.boa;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;

public interface ArithOpDivideOperation extends ArithOpOperation {
	EvalRes eval(Ctx ctx);
}
