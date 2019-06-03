package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Point extends EObject, NodeInterface {
	double getX();

	void setX(double value);

	double getY();

	void setY(double value);
}
