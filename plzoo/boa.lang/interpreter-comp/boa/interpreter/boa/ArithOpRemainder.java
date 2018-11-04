package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface ArithOpRemainder extends EObject, ArithOp {
  EvalRes eval(Ctx ctx);
}
