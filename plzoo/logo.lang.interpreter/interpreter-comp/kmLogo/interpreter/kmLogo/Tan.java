package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Tan extends EObject, UnaryExpression {
  double eval(Turtle turtle);
}
