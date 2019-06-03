package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Right extends EObject, NodeInterface, Primitive {
	Expression getAngle();

	void setAngle(Expression value);

	double eval(Turtle turtle);
}
