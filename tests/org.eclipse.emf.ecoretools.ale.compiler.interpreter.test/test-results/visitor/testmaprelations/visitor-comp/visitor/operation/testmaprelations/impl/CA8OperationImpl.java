package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA8;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA8Operation;

public class CA8OperationImpl implements CA8Operation {
	private final CA8 it;

	private final VisitorInterface vis;

	public CA8OperationImpl(CA8 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
