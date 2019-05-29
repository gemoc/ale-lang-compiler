package interpreter.boa.interpreter.boa;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface BObject extends EObject, Expr {
	EList<Field> getFields();

	EvalRes eval(Ctx ctx);
}
