package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA1;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA1Operation;

public class CA1OperationImpl implements CA1Operation {
	private final CA1 it;

	private final VisitorInterface vis;

	public CA1OperationImpl(CA1 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
