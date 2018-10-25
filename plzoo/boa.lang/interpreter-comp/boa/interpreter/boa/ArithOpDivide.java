package boa.interpreter.boa;

import boa_dynamic.interpreter.boa_dynamic.Ctx;
import boa_dynamic.interpreter.boa_dynamic.EvalRes;
import org.eclipse.emf.ecore.EObject;

public interface ArithOpDivide extends EObject, ArithOp {
  EvalRes eval(Ctx ctx);
}
