package visitor;

import java.lang.Object;
import testoperationbody.visitor.testoperationbody.ChildA;
import testoperationbody.visitor.testoperationbody.ChildB;
import testoperationbody.visitor.testoperationbody.ConceptA;
import testoperationbody.visitor.testoperationbody.Main;

public interface VisitorInterface {
	Object visittestoperationbody__Main(Main it);

	Object visittestoperationbody__ConceptA(ConceptA it);

	Object visittestoperationbody__ChildA(ChildA it);

	Object visittestoperationbody__ChildB(ChildB it);
}
