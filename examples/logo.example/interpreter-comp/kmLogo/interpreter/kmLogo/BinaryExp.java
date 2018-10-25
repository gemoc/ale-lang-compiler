package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface BinaryExp extends EObject, Expression {
  Expression getLhs();

  void setLhs(Expression value);

  Expression getRhs();

  void setRhs(Expression value);
}
