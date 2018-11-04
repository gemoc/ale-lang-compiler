package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface Int extends EObject, Expr {
  int getValue();

  void setValue(int value);

  EvalRes eval(Ctx ctx);
}
