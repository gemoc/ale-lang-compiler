package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface Minus extends EObject, BinaryExp {
  double eval(Turtle turtle);
}
