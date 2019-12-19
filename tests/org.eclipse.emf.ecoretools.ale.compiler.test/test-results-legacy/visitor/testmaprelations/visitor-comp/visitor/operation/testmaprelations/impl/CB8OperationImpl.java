package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB8;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB8Operation;

public class CB8OperationImpl implements CB8Operation {
	private final CB8 it;

	private final VisitorInterface vis;

	public CB8OperationImpl(CB8 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
