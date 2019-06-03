package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface While extends EObject, NodeInterface, ControlStructure {
	Block getBlock();

	void setBlock(Block value);

	double eval(Turtle turtle);
}
