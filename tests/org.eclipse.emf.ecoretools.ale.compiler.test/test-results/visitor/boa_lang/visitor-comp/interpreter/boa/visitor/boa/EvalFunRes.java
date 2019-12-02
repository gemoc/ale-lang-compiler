package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface EvalFunRes extends EObject, AcceptInterface, EvalRes {
	String getName();

	void setName(String value);

	Expr getExp();

	void setExp(Expr value);

	Ctx getCtx();

	void setCtx(Ctx value);
}
