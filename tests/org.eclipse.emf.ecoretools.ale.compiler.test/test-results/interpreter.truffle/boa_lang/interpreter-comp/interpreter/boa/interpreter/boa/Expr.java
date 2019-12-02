package interpreter.boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface Expr extends EObject, TopLevelCmd {
	EvalRes eval(Ctx ctx);

	void nextLine(Ctx ctx);
}
