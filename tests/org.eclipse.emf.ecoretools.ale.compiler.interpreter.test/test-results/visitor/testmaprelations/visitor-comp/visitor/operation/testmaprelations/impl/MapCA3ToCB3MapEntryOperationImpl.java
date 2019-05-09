package visitor.operation.testmaprelations.impl;

import testmaprelations.visitor.testmaprelations.MapCA3ToCB3MapEntry;
import visitor.VisitorInterface;
import visitor.operation.testmaprelations.MapCA3ToCB3MapEntryOperation;

public class MapCA3ToCB3MapEntryOperationImpl implements MapCA3ToCB3MapEntryOperation {
	private final MapCA3ToCB3MapEntry it;

	private final VisitorInterface vis;

	public MapCA3ToCB3MapEntryOperationImpl(MapCA3ToCB3MapEntry it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
