package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA4;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA4Operation;

public class CA4OperationImpl implements CA4Operation {
	private final CA4 it;

	private final VisitorInterface vis;

	public CA4OperationImpl(CA4 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
