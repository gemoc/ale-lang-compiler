package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA7ToCB7MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA7ToCB7MapEntryOperation;

public class MapCA7ToCB7MapEntryOperationImpl implements MapCA7ToCB7MapEntryOperation {
	private final MapCA7ToCB7MapEntry it;

	private final VisitorInterface vis;

	public MapCA7ToCB7MapEntryOperationImpl(MapCA7ToCB7MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
