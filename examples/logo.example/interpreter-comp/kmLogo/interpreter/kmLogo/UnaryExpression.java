package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface UnaryExpression extends EObject, Expression {
  Expression getExpression();

  void setExpression(Expression expression);
}
