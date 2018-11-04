package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface This extends EObject, Expr {
  EvalRes eval(Ctx ctx);
}
