package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Variable extends EObject, NodeInterface {
	String getName();

	void setName(String value);

	double getValue();

	void setValue(double value);
}
