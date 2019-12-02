package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA4ToCB4MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA4ToCB4MapEntryOperation;

public class MapCA4ToCB4MapEntryOperationImpl implements MapCA4ToCB4MapEntryOperation {
	private final MapCA4ToCB4MapEntry it;

	private final VisitorInterface vis;

	public MapCA4ToCB4MapEntryOperationImpl(MapCA4ToCB4MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
