package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Parameter extends EObject, NodeInterface {
	String getName();

	void setName(String value);
}
