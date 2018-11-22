package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Tan extends EObject, NodeInterface, UnaryExpression {
	double eval(Turtle turtle);
}
