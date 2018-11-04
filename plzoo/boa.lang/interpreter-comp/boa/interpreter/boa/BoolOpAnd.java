package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface BoolOpAnd extends EObject, BoolOp {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);

  EvalRes eval(Ctx ctx);
}
