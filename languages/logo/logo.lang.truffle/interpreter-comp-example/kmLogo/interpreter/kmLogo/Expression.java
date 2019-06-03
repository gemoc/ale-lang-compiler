package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Expression extends EObject, NodeInterface, Instruction {
	double eval(Turtle turtle);
}
