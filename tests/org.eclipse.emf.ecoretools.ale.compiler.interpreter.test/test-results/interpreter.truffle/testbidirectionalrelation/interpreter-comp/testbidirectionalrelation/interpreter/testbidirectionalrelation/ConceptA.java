package testbidirectionalrelation.interpreter.testbidirectionalrelation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ConceptA extends EObject {
	EList<ConceptB> getConceptb();

	EList<ConceptC> getConceptc();

	EList<ConceptD> getConceptd();

	EList<ConceptE> getConcepte();

	EList<ConceptF> getConceptf();

	EList<ConceptG> getConceptg();
}
