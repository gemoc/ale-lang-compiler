package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Parameter;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ParameterOperation;

public class ParameterOperationImpl implements ParameterOperation {
  private final Parameter it;

  private final VisitorInterface vis;

  public ParameterOperationImpl(Parameter it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }
}
