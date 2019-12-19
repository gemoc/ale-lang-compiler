package testoperationbody.interpreter.testoperationbody;

import org.eclipse.emf.ecore.EObject;

public interface ChildA extends EObject, Parent {
	EnumA getValue();

	void setValue(EnumA value);

	void overriden();

	EnumA onlyA();
}
