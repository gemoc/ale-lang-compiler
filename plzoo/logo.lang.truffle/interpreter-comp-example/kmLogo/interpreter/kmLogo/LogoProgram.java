package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface LogoProgram extends EObject, NodeInterface {
	EList<Instruction> getInstructions();

	Turtle eval();

	Turtle createTurtle();
}
