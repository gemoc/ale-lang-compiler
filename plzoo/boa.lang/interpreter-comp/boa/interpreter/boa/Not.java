package boa.interpreter.boa;

import boa_dynamic.interpreter.boa_dynamic.Ctx;
import boa_dynamic.interpreter.boa_dynamic.EvalRes;
import org.eclipse.emf.ecore.EObject;

public interface Not extends EObject, Expr {
  Expr getValue();

  void setValue(Expr value);

  EvalRes eval(Ctx ctx);
}
