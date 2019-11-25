package truffle.petrinet.interpreter.petrinet;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Petrinet extends EObject, NodeInterface {
  EList<Node> getNodes();

  EList<Arc> getArcs();

  void run();
}
