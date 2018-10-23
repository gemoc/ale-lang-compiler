package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface BinaryExp extends EObject, Expression {
  Expression getLhs();

  void setLhs(Expression lhs);

  Expression getRhs();

  void setRhs(Expression rhs);
}
