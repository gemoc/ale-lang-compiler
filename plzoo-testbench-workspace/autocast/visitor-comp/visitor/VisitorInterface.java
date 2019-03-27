package visitor;

import autocast.visitor.autocast.ConceptA;
import autocast.visitor.autocast.ConceptB;
import autocast.visitor.autocast.ConceptC;
import java.lang.Object;

public interface VisitorInterface {
	Object visitautocast__ConceptA(ConceptA it);

	Object visitautocast__ConceptB(ConceptB it);

	Object visitautocast__ConceptC(ConceptC it);
}
