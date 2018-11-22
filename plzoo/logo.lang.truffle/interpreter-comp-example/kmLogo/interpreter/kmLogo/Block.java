package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Block extends EObject, NodeInterface, Instruction {
	EList<Instruction> getInstructions();

	double eval(Turtle turtle);
}
