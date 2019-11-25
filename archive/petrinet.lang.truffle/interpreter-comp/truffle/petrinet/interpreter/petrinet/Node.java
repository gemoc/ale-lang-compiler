package truffle.petrinet.interpreter.petrinet;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import truffle.petrinet.interpreter.petrinet.impl.NodeDispatchWrapperFire;

public interface Node extends EObject, NodeInterface {
  String getName();

  void setName(String value);

  EList<Arc> getIncomming();

  EList<Arc> getOutgoing();

  boolean canFire();

  boolean hasToken();

  void fire();

  void removeToken();

  void addToken();

  NodeDispatchWrapperFire getCachedFire();
}
