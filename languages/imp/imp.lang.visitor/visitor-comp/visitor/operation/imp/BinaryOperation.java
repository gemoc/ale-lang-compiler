package visitor.operation.imp;

import imp.visitor.imp.Store;
import imp.visitor.imp.Value;

public interface BinaryOperation extends ExprOperation {
	Value evaluate(Store s);
}
