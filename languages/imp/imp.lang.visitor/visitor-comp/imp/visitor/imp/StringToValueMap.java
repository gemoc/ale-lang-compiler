package imp.visitor.imp;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface StringToValueMap extends EObject, AcceptInterface {
	String getKey();

	void setKey(String value);

	Value getValue();

	void setValue(Value value);
}
