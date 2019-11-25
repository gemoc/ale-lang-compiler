package petrinet.interpreter.petrinet;

import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Node extends EObject {
  String getName();

  void setName(String name);

  EList<Arc> getIncomming();

  EList<Arc> getOutgoing();

  boolean canFire();

  boolean hasToken();

  void fire();

  void removeToken();

  void addToken();
}
