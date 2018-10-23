package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface Expression extends EObject, Instruction {
  double eval(Turtle turtle);
}
