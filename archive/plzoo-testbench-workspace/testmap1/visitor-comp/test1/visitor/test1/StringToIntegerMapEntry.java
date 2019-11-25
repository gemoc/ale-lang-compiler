package test1.visitor.test1;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import visitor.AcceptInterface;

public interface StringToIntegerMapEntry extends EObject, AcceptInterface, EMap<String, Integer> {
	String getKey();

	void setKey(String value);

	Integer getValue();

	void setValue(Integer value);
}
