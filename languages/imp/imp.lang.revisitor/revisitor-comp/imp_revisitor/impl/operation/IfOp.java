package imp_revisitor.impl.operation;

import imp.model.imp.Store;

public interface IfOp extends StmtOp {
	Store execute(Store s);
}
