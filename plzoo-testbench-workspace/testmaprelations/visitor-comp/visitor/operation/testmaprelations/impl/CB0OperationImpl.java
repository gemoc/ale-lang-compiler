package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB0;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB0Operation;

public class CB0OperationImpl implements CB0Operation {
	private final CB0 it;

	private final VisitorInterface vis;

	public CB0OperationImpl(CB0 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
