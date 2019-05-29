package interpreter.boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface Bool extends EObject, Expr {
	boolean isValue();

	void setValue(boolean value);

	EvalRes eval(Ctx ctx);
}
