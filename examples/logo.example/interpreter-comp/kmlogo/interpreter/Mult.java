package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface Mult extends EObject, BinaryExp {
  double eval(Turtle turtle);
}
