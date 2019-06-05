package imp_revisitor.impl.operation;

import imp.model.imp.Store;
import imp.model.imp.Value;

public interface ExprOp {
	Value evaluate(Store s);
}
