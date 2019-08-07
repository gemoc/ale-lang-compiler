package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface If extends EObject, NodeInterface, ControlStructure {
	Block getThenPart();

	void setThenPart(Block value);

	Block getElsePart();

	void setElsePart(Block value);

	double eval(Turtle turtle);
}
