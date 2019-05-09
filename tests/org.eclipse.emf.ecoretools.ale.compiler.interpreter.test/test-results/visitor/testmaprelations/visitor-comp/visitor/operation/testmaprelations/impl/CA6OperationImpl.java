package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA6;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA6Operation;

public class CA6OperationImpl implements CA6Operation {
	private final CA6 it;

	private final VisitorInterface vis;

	public CA6OperationImpl(CA6 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
