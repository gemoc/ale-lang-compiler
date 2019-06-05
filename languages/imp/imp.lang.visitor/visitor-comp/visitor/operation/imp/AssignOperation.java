package visitor.operation.imp;

import imp.visitor.imp.Store;

public interface AssignOperation extends StmtOperation {
	Store execute(Store s);
}
