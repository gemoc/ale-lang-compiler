package truffle.petrinet.interpreter.petrinet;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Arc extends EObject, NodeInterface {
	Node getTarget();

	void setTarget(Node value);

	Node getSource();

	void setSource(Node value);

	boolean canFire();

	void removeToken();

	void addToken();
}
