package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA0;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA0Operation;

public class CA0OperationImpl implements CA0Operation {
	private final CA0 it;

	private final VisitorInterface vis;

	public CA0OperationImpl(CA0 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
