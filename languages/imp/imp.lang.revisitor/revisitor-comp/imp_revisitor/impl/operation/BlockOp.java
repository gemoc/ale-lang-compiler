package imp_revisitor.impl.operation;

import imp.model.imp.Store;

public interface BlockOp extends StmtOp {
	Store execute(Store s);
}
