package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface If extends EObject, NodeInterface, ControlStructure {
	Block getThenPart();

	void setThenPart(Block value);

	Block getElsePart();

	void setElsePart(Block value);

	double eval(Turtle turtle);
}
