package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface Equals extends EObject, BinaryExp {
  double eval(Turtle turtle);
}
