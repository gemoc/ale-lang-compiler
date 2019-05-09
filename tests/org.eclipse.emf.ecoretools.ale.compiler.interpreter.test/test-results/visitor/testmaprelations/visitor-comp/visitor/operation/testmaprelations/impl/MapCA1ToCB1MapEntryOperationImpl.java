package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA1ToCB1MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA1ToCB1MapEntryOperation;

public class MapCA1ToCB1MapEntryOperationImpl implements MapCA1ToCB1MapEntryOperation {
	private final MapCA1ToCB1MapEntry it;

	private final VisitorInterface vis;

	public MapCA1ToCB1MapEntryOperationImpl(MapCA1ToCB1MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
