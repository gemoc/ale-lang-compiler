package petrinet.interpreter.petrinet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Petrinet extends EObject {
  EList<Node> getNodes();

  EList<Arc> getArcs();

  void run();
}
