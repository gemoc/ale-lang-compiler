package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Cos extends EObject, NodeInterface, UnaryExpression {
	double eval(Turtle turtle);
}
