package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA5ToCB5MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA5ToCB5MapEntryOperation;

public class MapCA5ToCB5MapEntryOperationImpl implements MapCA5ToCB5MapEntryOperation {
	private final MapCA5ToCB5MapEntry it;

	private final VisitorInterface vis;

	public MapCA5ToCB5MapEntryOperationImpl(MapCA5ToCB5MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
