package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB9;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB9Operation;

public class CB9OperationImpl implements CB9Operation {
	private final CB9 it;

	private final VisitorInterface vis;

	public CB9OperationImpl(CB9 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
