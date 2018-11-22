package visitor.visitor.operation.petrinet.impl;

import visitor.petrinet.visitor.petrinet.Node;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.petrinet.NodeOperation;

public abstract class NodeOperationImpl implements NodeOperation {
  private final Node it;

  private final VisitorInterface vis;

  public NodeOperationImpl(Node it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }

  public boolean canFire() {
    boolean result;
    result = false;
    return result;
  }

  public boolean hasToken() {
    boolean result;
    result = false;
    return result;
  }

  public void fire() {
  }

  public void removeToken() {
  }

  public void addToken() {
  }
}
