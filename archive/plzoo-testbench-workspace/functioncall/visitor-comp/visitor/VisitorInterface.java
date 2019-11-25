package visitor;

import functioncall.visitor.functioncall.ConceptA;
import functioncall.visitor.functioncall.ConceptB;
import functioncall.visitor.functioncall.ConceptC;
import java.lang.Object;

public interface VisitorInterface {
	Object visitfunctioncall__ConceptA(ConceptA it);

	Object visitfunctioncall__ConceptB(ConceptB it);

	Object visitfunctioncall__ConceptC(ConceptC it);
}
