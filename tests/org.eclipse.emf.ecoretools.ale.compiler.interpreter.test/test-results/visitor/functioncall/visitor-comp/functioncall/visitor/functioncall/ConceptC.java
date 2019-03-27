package functioncall.visitor.functioncall;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptC extends EObject, AcceptInterface {
	ConceptA getConcepta2();

	void setConcepta2(ConceptA value);

	ConceptA getConcepta1();

	void setConcepta1(ConceptA value);

	ConceptB getConceptb();

	void setConceptb(ConceptB value);
}
