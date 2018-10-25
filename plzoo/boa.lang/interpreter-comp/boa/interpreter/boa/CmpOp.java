package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface CmpOp extends EObject, Expr {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);
}
