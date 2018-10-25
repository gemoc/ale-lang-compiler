package boa.interpreter.boa;

import boa_dynamic.interpreter.boa_dynamic.Ctx;
import boa_dynamic.interpreter.boa_dynamic.EvalRes;
import org.eclipse.emf.ecore.EObject;

public interface CmpOpEqual extends EObject, CmpOp {
  EvalRes eval(Ctx ctx);
}
