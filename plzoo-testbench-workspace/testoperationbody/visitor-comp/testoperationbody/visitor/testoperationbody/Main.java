package testoperationbody.visitor.testoperationbody;

import java.lang.Integer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Main extends EObject, AcceptInterface {
	EList<Integer> getListint();

	boolean isSinglebool();

	void setSinglebool(boolean value);

	EList<ConceptA> getListconcepta();

	ConceptA getSingleconcepta();

	void setSingleconcepta(ConceptA value);

	EList<Parent> getChildren();
}
