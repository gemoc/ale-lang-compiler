package visitor.petrinet.visitor.petrinet;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface Place extends EObject, AcceptInterface, Node {
  int getTokenNb();

  void setTokenNb(int value);
}
