package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.CA7;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.CA7Operation;

public class CA7OperationImpl implements CA7Operation {
	private final CA7 it;

	private final VisitorInterface vis;

	public CA7OperationImpl(CA7 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
