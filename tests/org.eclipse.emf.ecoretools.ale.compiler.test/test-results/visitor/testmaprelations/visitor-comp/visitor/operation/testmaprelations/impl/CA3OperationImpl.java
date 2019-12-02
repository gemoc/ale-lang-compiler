package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA3;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA3Operation;

public class CA3OperationImpl implements CA3Operation {
	private final CA3 it;

	private final VisitorInterface vis;

	public CA3OperationImpl(CA3 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
