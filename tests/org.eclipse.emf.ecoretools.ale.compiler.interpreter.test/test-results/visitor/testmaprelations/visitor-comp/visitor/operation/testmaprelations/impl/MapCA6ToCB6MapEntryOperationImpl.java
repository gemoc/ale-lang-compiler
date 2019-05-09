package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA6ToCB6MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA6ToCB6MapEntryOperation;

public class MapCA6ToCB6MapEntryOperationImpl implements MapCA6ToCB6MapEntryOperation {
	private final MapCA6ToCB6MapEntry it;

	private final VisitorInterface vis;

	public MapCA6ToCB6MapEntryOperationImpl(MapCA6ToCB6MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
