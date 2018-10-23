package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface PenUp extends EObject, Primitive {
  double eval(Turtle turtle);
}
