package visitor.visitor.operation.petrinet.impl;

import visitor.petrinet.visitor.petrinet.Node;
import visitor.petrinet.visitor.petrinet.Petrinet;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.petrinet.PetrinetOperation;

public class PetrinetOperationImpl implements PetrinetOperation {
  private final Petrinet it;

  private final VisitorInterface vis;

  public PetrinetOperationImpl(Petrinet it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }

  public void run() {
    boolean stop = ((boolean)false);
    while (!(stop)) {
      Node enabledNode = ((Node)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.it.getNodes(), (n) -> ((visitor.visitor.operation.petrinet.NodeOperation)n.accept(vis)).canFire())));
      org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(enabledNode);
      if((enabledNode) != (null)) {
        ((visitor.visitor.operation.petrinet.NodeOperation)enabledNode.accept(vis)).fire();
      }
      else {
        stop = true;
      }
    }
  }
}
