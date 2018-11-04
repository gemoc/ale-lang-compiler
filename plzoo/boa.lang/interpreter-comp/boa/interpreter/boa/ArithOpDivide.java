package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface ArithOpDivide extends EObject, ArithOp {
  EvalRes eval(Ctx ctx);
}
