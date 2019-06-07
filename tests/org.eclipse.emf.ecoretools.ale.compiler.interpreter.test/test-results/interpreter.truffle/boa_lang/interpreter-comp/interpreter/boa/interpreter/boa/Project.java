package interpreter.boa.interpreter.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Project extends EObject, Expr {
	String getName();

	void setName(String value);

	Expr getExp();

	void setExp(Expr value);

	EvalRes eval(Ctx ctx);

	EvalRes project(EvalFunRes func, EvalMapRes mvexp);
}
