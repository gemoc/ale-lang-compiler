package testoperationbody.interpreter.testoperationbody;

import java.lang.Integer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Main extends EObject {
	EList<Integer> getListint();

	boolean isSinglebool();

	void setSinglebool(boolean value);

	EList<ConceptA> getListconcepta();

	ConceptA getSingleconcepta();

	void setSingleconcepta(ConceptA value);

	EList<Parent> getChildren();

	void testPolymorphism();

	void main();

	int ma();
}
