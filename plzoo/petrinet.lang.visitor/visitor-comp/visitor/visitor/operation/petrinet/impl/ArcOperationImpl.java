package visitor.visitor.operation.petrinet.impl;

import visitor.petrinet.visitor.petrinet.Arc;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.petrinet.ArcOperation;

public class ArcOperationImpl implements ArcOperation {
  private final Arc it;

  private final VisitorInterface vis;

  public ArcOperationImpl(Arc it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }

  public boolean canFire() {
    boolean result;
    result = ((visitor.visitor.operation.petrinet.NodeOperation)this.it.getSource().accept(vis)).hasToken();
    return result;
  }

  public void removeToken() {
    ((visitor.visitor.operation.petrinet.NodeOperation)this.it.getSource().accept(vis)).removeToken();
  }

  public void addToken() {
    ((visitor.visitor.operation.petrinet.NodeOperation)this.it.getTarget().accept(vis)).addToken();
  }
}
