package petrinet.interpreter.petrinet;

import org.eclipse.emf.ecore.EObject;

public interface Transition extends EObject, Node {
  boolean canFire();

  boolean hasToken();

  void fire();

  void removeToken();

  void addToken();
}
