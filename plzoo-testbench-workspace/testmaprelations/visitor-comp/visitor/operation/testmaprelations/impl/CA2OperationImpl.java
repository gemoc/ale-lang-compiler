package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA2;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA2Operation;

public class CA2OperationImpl implements CA2Operation {
	private final CA2 it;

	private final VisitorInterface vis;

	public CA2OperationImpl(CA2 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
