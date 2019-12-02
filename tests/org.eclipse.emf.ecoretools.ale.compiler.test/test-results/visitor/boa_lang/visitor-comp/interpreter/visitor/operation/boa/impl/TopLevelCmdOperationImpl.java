package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.TopLevelCmd;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.TopLevelCmdOperation;

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
