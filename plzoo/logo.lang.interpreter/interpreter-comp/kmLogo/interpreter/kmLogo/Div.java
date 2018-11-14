package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Div extends EObject, BinaryExp {
  double eval(Turtle turtle);
}
