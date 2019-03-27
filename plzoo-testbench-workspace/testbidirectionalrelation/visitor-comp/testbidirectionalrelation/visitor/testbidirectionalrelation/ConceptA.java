package testbidirectionalrelation.visitor.testbidirectionalrelation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA extends EObject, AcceptInterface {
	EList<ConceptB> getConceptb();

	EList<ConceptC> getConceptc();

	EList<ConceptD> getConceptd();

	EList<ConceptE> getConcepte();

	EList<ConceptF> getConceptf();

	EList<ConceptG> getConceptg();
}
