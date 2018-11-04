package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface UnaryExpression extends EObject, AcceptInterface, Expression {
  Expression getExpression();

  void setExpression(Expression value);
}
