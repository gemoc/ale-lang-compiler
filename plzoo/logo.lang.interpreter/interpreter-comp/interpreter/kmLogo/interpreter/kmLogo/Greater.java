package interpreter.kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Greater extends EObject, BinaryExp {
	double eval(Turtle turtle);
}
