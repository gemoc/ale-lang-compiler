package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB3;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB3Operation;

public class CB3OperationImpl implements CB3Operation {
	private final CB3 it;

	private final VisitorInterface vis;

	public CB3OperationImpl(CB3 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
