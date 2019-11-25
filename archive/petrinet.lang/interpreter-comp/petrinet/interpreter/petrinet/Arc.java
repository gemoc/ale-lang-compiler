package petrinet.interpreter.petrinet;

import org.eclipse.emf.ecore.EObject;

public interface Arc extends EObject {
  Node getTarget();

  void setTarget(Node target);

  Node getSource();

  void setSource(Node source);

  boolean canFire();

  void removeToken();

  void addToken();
}
