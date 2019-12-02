package visitor;

import factorydeclorder.visitor.factorydeclorder.A;
import factorydeclorder.visitor.factorydeclorder.B;
import factorydeclorder.visitor.factorydeclorder.C;
import factorydeclorder.visitor.factorydeclorder.D;
import java.lang.Object;

public interface VisitorInterface {
	Object visitfactorydeclorder__C(C it);

	Object visitfactorydeclorder__A(A it);

	Object visitfactorydeclorder__B(B it);

	Object visitfactorydeclorder__D(D it);
}
