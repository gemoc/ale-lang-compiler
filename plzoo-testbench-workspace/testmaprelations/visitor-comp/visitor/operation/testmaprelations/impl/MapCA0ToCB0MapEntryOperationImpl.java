package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA0ToCB0MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA0ToCB0MapEntryOperation;

public class MapCA0ToCB0MapEntryOperationImpl implements MapCA0ToCB0MapEntryOperation {
	private final MapCA0ToCB0MapEntry it;

	private final VisitorInterface vis;

	public MapCA0ToCB0MapEntryOperationImpl(MapCA0ToCB0MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
