package visitor.operation.boa;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalRes;

public interface CmpOpLessOperation extends CmpOpOperation {
	EvalRes eval(Ctx ctx);
}
