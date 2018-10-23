package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface Instruction extends EObject {
  double eval(Turtle turtle);
}
