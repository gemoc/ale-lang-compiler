package visitor.petrinet.visitor.petrinet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface Petrinet extends EObject, AcceptInterface {
	EList<Node> getNodes();

	EList<Arc> getArcs();
}
