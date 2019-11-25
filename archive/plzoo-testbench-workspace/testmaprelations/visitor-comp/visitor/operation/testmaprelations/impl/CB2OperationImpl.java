package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB2;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB2Operation;

public class CB2OperationImpl implements CB2Operation {
	private final CB2 it;

	private final VisitorInterface vis;

	public CB2OperationImpl(CB2 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
