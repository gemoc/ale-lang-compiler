package visitor;

import testaccessors.visitor.testaccessors.EAcc;
import visitor.operation.testaccessors.EAccOperation;
import visitor.operation.testaccessors.impl.EAccOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public EAccOperation visittestaccessors__EAcc(EAcc it) {
		return new EAccOperationImpl(it, this);
	}
}
