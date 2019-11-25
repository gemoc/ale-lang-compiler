package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB1;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB1Operation;

public class CB1OperationImpl implements CB1Operation {
	private final CB1 it;

	private final VisitorInterface vis;

	public CB1OperationImpl(CB1 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
