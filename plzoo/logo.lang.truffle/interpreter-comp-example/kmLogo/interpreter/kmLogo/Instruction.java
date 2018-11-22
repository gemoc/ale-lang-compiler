package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Instruction extends EObject, NodeInterface {
	double eval(Turtle turtle);
}
