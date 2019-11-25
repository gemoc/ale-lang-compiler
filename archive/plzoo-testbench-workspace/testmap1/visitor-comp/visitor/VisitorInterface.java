package visitor;

import java.lang.Object;
import test1.visitor.test1.ConceptA;
import test1.visitor.test1.StringToIntegerMapEntry;

public interface VisitorInterface {
	Object visittest1__ConceptA(ConceptA it);

	Object visittest1__StringToIntegerMapEntry(StringToIntegerMapEntry it);
}
