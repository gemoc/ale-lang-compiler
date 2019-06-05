package visitor.operation.imp;

import imp.visitor.imp.Store;

public interface IfOperation extends StmtOperation {
	Store execute(Store s);
}
