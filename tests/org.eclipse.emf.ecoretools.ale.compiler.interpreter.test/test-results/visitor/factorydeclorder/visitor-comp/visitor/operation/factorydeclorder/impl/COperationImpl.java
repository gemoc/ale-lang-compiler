package visitor.operation.factorydeclorder.impl;

import factorydeclorder.visitor.factorydeclorder.C;
import visitor.VisitorInterface;
import visitor.operation.factorydeclorder.COperation;

public class COperationImpl extends BOperationImpl implements COperation {
	private final C it;

	private final VisitorInterface vis;

	public COperationImpl(C it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
