package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Clear extends EObject, Primitive {
	double eval(Turtle turtle);
}
