package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Clear extends EObject, NodeInterface, Primitive {
	double eval(Turtle turtle);
}
