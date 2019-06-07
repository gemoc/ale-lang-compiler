package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Minus extends EObject, BinaryExp {
	double eval(Turtle turtle);
}
