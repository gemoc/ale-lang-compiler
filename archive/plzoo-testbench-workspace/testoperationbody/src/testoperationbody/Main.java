
package testoperationbody;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;


public interface Main extends EObject {
	
	EList<Integer> getListint();

	
	EList<ConceptA> getListconcepta();

	
	boolean isSinglebool();

	
	void setSinglebool(boolean value);

	
	ConceptA getSingleconcepta();

	
	void setSingleconcepta(ConceptA value);

	
	EList<Parent> getChildren();

} // Main
