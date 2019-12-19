package testbidirectionalrelation.visitor.testbidirectionalrelation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptG extends EObject, AcceptInterface {
	EList<ConceptF> getConceptf();
}
