package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Forward extends EObject, NodeInterface, Primitive {
	Expression getSteps();

	void setSteps(Expression value);

	double eval(Turtle turtle);
}
