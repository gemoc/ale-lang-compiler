package visitor;

import testenums.visitor.testenums.Root;
import visitor.operation.testenums.RootOperation;
import visitor.operation.testenums.impl.RootOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public RootOperation visittestenums__Root(Root it) {
		return new RootOperationImpl(it, this);
	}
}
