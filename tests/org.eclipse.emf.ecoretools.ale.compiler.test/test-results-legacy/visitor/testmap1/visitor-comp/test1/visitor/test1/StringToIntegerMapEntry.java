package test1.visitor.test1;

import java.lang.Integer;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface StringToIntegerMapEntry extends EObject, AcceptInterface {
	String getKey();

	void setKey(String value);

	Integer getValue();

	void setValue(Integer value);
}
