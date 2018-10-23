package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface ControlStructure extends EObject, Instruction {
  Expression getCondition();

  void setCondition(Expression condition);
}
