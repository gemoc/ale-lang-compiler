package interpreter.boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface CmpOpEqual extends EObject, CmpOp {
	EvalRes eval(Ctx ctx);
}
