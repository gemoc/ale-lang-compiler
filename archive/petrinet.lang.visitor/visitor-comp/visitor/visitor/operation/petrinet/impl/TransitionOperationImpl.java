package visitor.visitor.operation.petrinet.impl;

import visitor.petrinet.visitor.petrinet.Arc;
import visitor.petrinet.visitor.petrinet.Transition;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.petrinet.TransitionOperation;

public class TransitionOperationImpl implements TransitionOperation {
  private final Transition it;

  private final VisitorInterface vis;

  public TransitionOperationImpl(Transition it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }

  public boolean canFire() {
    boolean result;
    result = !(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.isEmpty(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.it.getIncomming(), (it) -> ((visitor.visitor.operation.petrinet.ArcOperation)it.accept(vis)).canFire())));
    return result;
  }

  public boolean hasToken() {
    boolean result;
    result = false;
    return result;
  }

  public void fire() {
    for(Arc it: this.it.getIncomming()) {
      ((visitor.visitor.operation.petrinet.ArcOperation)it.accept(vis)).removeToken();
    }
    for(Arc it: this.it.getOutgoing()) {
      ((visitor.visitor.operation.petrinet.ArcOperation)it.accept(vis)).addToken();
    }
  }

  public void removeToken() {
  }

  public void addToken() {
  }
}
