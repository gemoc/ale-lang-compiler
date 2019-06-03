package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface ControlStructure extends EObject, NodeInterface, Instruction {
  Expression getCondition();

  void setCondition(Expression value);
}
