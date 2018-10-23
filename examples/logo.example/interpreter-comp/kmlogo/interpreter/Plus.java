package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface Plus extends EObject, BinaryExp {
  double eval(Turtle turtle);
}
