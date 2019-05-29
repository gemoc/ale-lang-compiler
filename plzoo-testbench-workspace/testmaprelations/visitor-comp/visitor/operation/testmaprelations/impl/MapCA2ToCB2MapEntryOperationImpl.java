package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA2ToCB2MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA2ToCB2MapEntryOperation;

public class MapCA2ToCB2MapEntryOperationImpl implements MapCA2ToCB2MapEntryOperation {
	private final MapCA2ToCB2MapEntry it;

	private final VisitorInterface vis;

	public MapCA2ToCB2MapEntryOperationImpl(MapCA2ToCB2MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
