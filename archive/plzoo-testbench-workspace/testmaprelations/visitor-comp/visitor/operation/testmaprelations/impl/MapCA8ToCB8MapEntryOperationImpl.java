package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA8ToCB8MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA8ToCB8MapEntryOperation;

public class MapCA8ToCB8MapEntryOperationImpl implements MapCA8ToCB8MapEntryOperation {
	private final MapCA8ToCB8MapEntry it;

	private final VisitorInterface vis;

	public MapCA8ToCB8MapEntryOperationImpl(MapCA8ToCB8MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
