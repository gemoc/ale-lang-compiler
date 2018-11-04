package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface ArithOpTimes extends EObject, ArithOp {
  EvalRes eval(Ctx ctx);
}
