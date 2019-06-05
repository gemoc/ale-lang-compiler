package visitor.operation.imp;

import imp.visitor.imp.Store;

public interface StmtOperation {
	Store execute(Store s);
}
