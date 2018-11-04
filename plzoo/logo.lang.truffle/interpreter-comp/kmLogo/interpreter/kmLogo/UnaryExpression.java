package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface UnaryExpression extends EObject, NodeInterface, Expression {
  Expression getExpression();

  void setExpression(Expression value);
}
