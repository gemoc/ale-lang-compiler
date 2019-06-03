package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Segment;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.SegmentOperation;

public class SegmentOperationImpl implements SegmentOperation {
	private final Segment it;

	private final VisitorInterface vis;

	public SegmentOperationImpl(Segment it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
