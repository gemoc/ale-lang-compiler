package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface CmpOpUnequal extends EObject, CmpOp {
  EvalRes eval(Ctx ctx);
}
