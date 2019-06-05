package visitor.operation.imp;

import imp.visitor.imp.Store;

public interface BlockOperation extends StmtOperation {
	Store execute(Store s);
}
