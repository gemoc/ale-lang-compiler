package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface ArithOp extends EObject, Expr {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);
}
