package testoperationbody.visitor.testoperationbody;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ChildA extends EObject, AcceptInterface, Parent {
	EnumA getValue();

	void setValue(EnumA value);
}
