package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB5;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB5Operation;

public class CB5OperationImpl implements CB5Operation {
	private final CB5 it;

	private final VisitorInterface vis;

	public CB5OperationImpl(CB5 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
