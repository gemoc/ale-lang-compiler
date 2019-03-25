package test1.interpreter.test1;

import java.lang.Integer;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface StringToIntegerMapEntry extends EObject {
	String getKey();

	void setKey(String value);

	Integer getValue();

	void setValue(Integer value);
}
