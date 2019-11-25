package truffle.petrinet.interpreter.petrinet;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Transition extends EObject, NodeInterface, Node {
  boolean canFire();

  boolean hasToken();

  void fire();

  void removeToken();

  void addToken();
}
