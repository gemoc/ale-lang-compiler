package visitor.petrinet.visitor.petrinet;

import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface Node extends EObject, AcceptInterface {
  String getName();

  void setName(String value);

  EList<Arc> getIncomming();

  EList<Arc> getOutgoing();
}
