package petrinet.interpreter.petrinet;

import org.eclipse.emf.ecore.EObject;

public interface Place extends EObject, Node {
  int getTokenNb();

  void setTokenNb(int tokenNb);

  boolean canFire();

  boolean hasToken();

  void fire();

  void removeToken();

  void addToken();
}
