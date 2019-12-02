package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA5;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA5Operation;

public class CA5OperationImpl implements CA5Operation {
	private final CA5 it;

	private final VisitorInterface vis;

	public CA5OperationImpl(CA5 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
