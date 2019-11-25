package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ControlStructure extends EObject, AcceptInterface, Instruction {
  Expression getCondition();

  void setCondition(Expression value);
}
