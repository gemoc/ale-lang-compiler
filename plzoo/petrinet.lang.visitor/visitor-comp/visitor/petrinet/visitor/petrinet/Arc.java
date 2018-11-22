package visitor.petrinet.visitor.petrinet;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface Arc extends EObject, AcceptInterface {
  Node getTarget();

  void setTarget(Node value);

  Node getSource();

  void setSource(Node value);
}
