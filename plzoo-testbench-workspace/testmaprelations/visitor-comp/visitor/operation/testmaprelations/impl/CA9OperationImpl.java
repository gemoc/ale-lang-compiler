package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA9;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA9Operation;

public class CA9OperationImpl implements CA9Operation {
	private final CA9 it;

	private final VisitorInterface vis;

	public CA9OperationImpl(CA9 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
