package testbidirectionalrelation.interpreter.testbidirectionalrelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

public interface ConceptG extends EObject {
	EList<ConceptF> getConceptf();
}