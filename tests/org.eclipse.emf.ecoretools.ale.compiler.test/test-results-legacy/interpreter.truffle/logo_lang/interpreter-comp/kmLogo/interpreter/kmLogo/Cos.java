package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Cos extends EObject, UnaryExpression {
	double eval(Turtle turtle);
}
