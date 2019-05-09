package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CB6;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CB6Operation;

public class CB6OperationImpl implements CB6Operation {
	private final CB6 it;

	private final VisitorInterface vis;

	public CB6OperationImpl(CB6 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
