package truffle.petrinet.interpreter.petrinet;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Place extends EObject, NodeInterface, Node {
	int getTokenNb();

	void setTokenNb(int value);

	boolean canFire();

	boolean hasToken();

	void fire();

	void removeToken();

	void addToken();
}
