package test1.interpreter.test1;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface StringToIntegerMapEntry extends EObject, EMap<String, Integer> {
	String getKey();

	void setKey(String value);

	Integer getValue();

	void setValue(Integer value);
}
