package interpreter.boa.interpreter.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Fun extends EObject, Expr {
	String getName();

	void setName(String value);

	Expr getBody();

	void setBody(Expr value);

	EvalRes eval(Ctx ctx);
}
