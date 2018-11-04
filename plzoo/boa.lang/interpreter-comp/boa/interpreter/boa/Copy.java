package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface Copy extends EObject, Expr {
  Expr getCopy();

  void setCopy(Expr value);

  EvalRes eval(Ctx ctx);
}
