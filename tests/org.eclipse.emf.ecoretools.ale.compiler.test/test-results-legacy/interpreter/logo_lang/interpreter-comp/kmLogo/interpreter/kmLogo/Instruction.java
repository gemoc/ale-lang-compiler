package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Instruction extends EObject {
	double eval(Turtle turtle);
}
