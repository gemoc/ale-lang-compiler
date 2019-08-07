package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Repeat extends EObject, NodeInterface, ControlStructure {
	Block getBlock();

	void setBlock(Block value);

	double eval(Turtle turtle);
}
