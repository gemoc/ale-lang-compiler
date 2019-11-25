package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Point;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.PointOperation;

public class PointOperationImpl implements PointOperation {
  private final Point it;

  private final VisitorInterface vis;

  public PointOperationImpl(Point it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }
}
