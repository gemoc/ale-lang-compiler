package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface PenDown extends EObject, Primitive {
  double eval(Turtle turtle);
}
