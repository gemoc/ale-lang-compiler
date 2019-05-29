package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB7;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB7Operation;

public class CB7OperationImpl implements CB7Operation {
	private final CB7 it;

	private final VisitorInterface vis;

	public CB7OperationImpl(CB7 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
