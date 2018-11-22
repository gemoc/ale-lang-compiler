package interpreter.boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface ArithOpMinus extends EObject, ArithOp {
  EvalRes eval(Ctx ctx);
}
