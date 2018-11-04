package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.TopLevelCmd;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.TopLevelCmdOperation;

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
