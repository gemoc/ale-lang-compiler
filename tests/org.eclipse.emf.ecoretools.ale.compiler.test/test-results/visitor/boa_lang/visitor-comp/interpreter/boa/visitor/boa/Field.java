package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Field extends EObject, AcceptInterface {
	String getName();

	void setName(String value);

	Expr getValue();

	void setValue(Expr value);
}
