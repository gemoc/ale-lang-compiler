package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface StringToEvalResMap extends EObject, AcceptInterface {
	String getKey();

	void setKey(String value);

	EvalRes getValue();

	void setValue(EvalRes value);
}
