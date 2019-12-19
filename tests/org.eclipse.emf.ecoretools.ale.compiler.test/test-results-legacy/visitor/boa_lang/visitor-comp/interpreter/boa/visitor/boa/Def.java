package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Def extends EObject, AcceptInterface, TopLevelCmd {
	String getName();

	void setName(String value);

	Expr getExpr();

	void setExpr(Expr value);
}
