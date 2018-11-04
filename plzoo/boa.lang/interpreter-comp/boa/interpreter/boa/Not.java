package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface Not extends EObject, Expr {
  Expr getValue();

  void setValue(Expr value);

  EvalRes eval(Ctx ctx);
}
