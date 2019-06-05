package visitor.operation.imp;

import imp.visitor.imp.Store;

public interface SkipOperation extends StmtOperation {
	Store execute(Store s);
}
