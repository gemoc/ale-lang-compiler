package functioncall.interpreter.functioncall;

import org.eclipse.emf.ecore.EObject;

public interface ConceptC extends EObject {
	ConceptA getConcepta2();

	void setConcepta2(ConceptA value);

	ConceptA getConcepta1();

	void setConcepta1(ConceptA value);

	ConceptB getConceptb();

	void setConceptb(ConceptB value);

	void exec1();
}
