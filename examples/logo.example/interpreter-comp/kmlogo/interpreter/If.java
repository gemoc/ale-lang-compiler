package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface If extends EObject, ControlStructure {
  Block getThenPart();

  void setThenPart(Block thenPart);

  Block getElsePart();

  void setElsePart(Block elsePart);

  double eval(Turtle turtle);
}
