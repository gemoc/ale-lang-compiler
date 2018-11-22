package interpreter.boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface CmpOpLess extends EObject, CmpOp {
  EvalRes eval(Ctx ctx);
}
