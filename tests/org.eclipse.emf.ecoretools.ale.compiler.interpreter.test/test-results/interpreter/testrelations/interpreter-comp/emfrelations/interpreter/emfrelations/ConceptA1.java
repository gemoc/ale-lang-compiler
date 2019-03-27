package emfrelations.interpreter.emfrelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ConceptA1 extends EObject {
	EList<ConceptB1> getConceptb1();
	
	void logBS();
}
