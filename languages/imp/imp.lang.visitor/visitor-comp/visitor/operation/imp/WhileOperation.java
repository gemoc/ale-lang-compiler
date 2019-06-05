package visitor.operation.imp;

import imp.visitor.imp.Store;

public interface WhileOperation extends StmtOperation {
	Store execute(Store s);
}
