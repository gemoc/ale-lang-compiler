package boa.interpreter.boa;

import boa_dynamic.interpreter.boa_dynamic.Ctx;
import boa_dynamic.interpreter.boa_dynamic.EvalRes;
import org.eclipse.emf.ecore.EObject;

public interface Expr extends EObject, TopLevelCmd {
  EvalRes eval(Ctx ctx);

  void nextLine(Ctx ctx);
}
