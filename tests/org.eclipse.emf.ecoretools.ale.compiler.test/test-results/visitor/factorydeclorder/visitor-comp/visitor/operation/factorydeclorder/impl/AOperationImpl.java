package visitor.operation.factorydeclorder.impl;

import factorydeclorder.visitor.factorydeclorder.A;
import visitor.VisitorInterface;
import visitor.operation.factorydeclorder.AOperation;

public class AOperationImpl extends DOperationImpl implements AOperation {
	private final A it;

	private final VisitorInterface vis;

	public AOperationImpl(A it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
