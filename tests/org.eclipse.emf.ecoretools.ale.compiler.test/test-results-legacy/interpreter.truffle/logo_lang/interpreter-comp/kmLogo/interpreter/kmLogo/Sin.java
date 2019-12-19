package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Sin extends EObject, UnaryExpression {
	double eval(Turtle turtle);
}
