package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface Skip extends EObject, Expr {
  EvalRes eval(Ctx ctx);
}
