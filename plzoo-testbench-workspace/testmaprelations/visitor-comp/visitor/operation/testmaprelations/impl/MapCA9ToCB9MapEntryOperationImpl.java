package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA9ToCB9MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA9ToCB9MapEntryOperation;

public class MapCA9ToCB9MapEntryOperationImpl implements MapCA9ToCB9MapEntryOperation {
	private final MapCA9ToCB9MapEntry it;

	private final VisitorInterface vis;

	public MapCA9ToCB9MapEntryOperationImpl(MapCA9ToCB9MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
