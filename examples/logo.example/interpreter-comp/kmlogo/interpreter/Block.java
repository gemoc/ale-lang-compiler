package kmlogo.interpreter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Block extends EObject, Instruction {
  EList<Instruction> getInstructions();

  double eval(Turtle turtle);
}
