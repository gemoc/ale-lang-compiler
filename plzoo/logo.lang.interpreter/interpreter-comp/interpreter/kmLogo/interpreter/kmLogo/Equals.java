package interpreter.kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Equals extends EObject, BinaryExp {
	double eval(Turtle turtle);
}
