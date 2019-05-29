package interpreter.kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface LogoProgram extends EObject {
	EList<Instruction> getInstructions();

	Turtle eval();

	Turtle createTurtle();
}
