package testbidirectionalrelation.visitor.testbidirectionalrelation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptF extends EObject, AcceptInterface {
	EList<ConceptG> getConceptg();
}
