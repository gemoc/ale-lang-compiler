package visitor;

import java.lang.Object;
import test1.visitor.test1.ConceptA;
import test1.visitor.test1.ConceptB;
import test1.visitor.test1.ConceptC;

public interface VisitorInterface {
	Object visittest1__ConceptA(ConceptA it);

	Object visittest1__ConceptB(ConceptB it);

	Object visittest1__ConceptC(ConceptC it);
}
