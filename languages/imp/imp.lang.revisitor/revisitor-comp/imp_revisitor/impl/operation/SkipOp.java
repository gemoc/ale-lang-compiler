package imp_revisitor.impl.operation;

import imp.model.imp.Store;

public interface SkipOp extends StmtOp {
	Store execute(Store s);
}
