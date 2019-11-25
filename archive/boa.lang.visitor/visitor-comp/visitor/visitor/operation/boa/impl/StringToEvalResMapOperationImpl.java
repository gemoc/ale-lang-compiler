package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.StringToEvalResMap;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.StringToEvalResMapOperation;

public class StringToEvalResMapOperationImpl implements StringToEvalResMapOperation {
  private final StringToEvalResMap it;

  private final VisitorInterface vis;

  public StringToEvalResMapOperationImpl(StringToEvalResMap it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }
}
