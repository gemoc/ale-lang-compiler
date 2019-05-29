package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB4;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB4Operation;

public class CB4OperationImpl implements CB4Operation {
	private final CB4 it;

	private final VisitorInterface vis;

	public CB4OperationImpl(CB4 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
