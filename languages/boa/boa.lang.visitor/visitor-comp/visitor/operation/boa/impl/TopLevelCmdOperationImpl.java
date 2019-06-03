package visitor.operation.boa.impl;

import boa.visitor.boa.Ctx;
import boa.visitor.boa.TopLevelCmd;
import visitor.VisitorInterface;
import visitor.operation.boa.TopLevelCmdOperation;

public abstract class TopLevelCmdOperationImpl implements TopLevelCmdOperation {
	private final TopLevelCmd it;

	private final VisitorInterface vis;

	public TopLevelCmdOperationImpl(TopLevelCmd it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void nextLine(Ctx ctx) {
	}
}
