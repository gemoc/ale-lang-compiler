package visitor;

import java.lang.Object;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptA;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptG;

public interface VisitorInterface {
	Object visittestbidirectionalrelation__ConceptA(ConceptA it);

	Object visittestbidirectionalrelation__ConceptB(ConceptB it);

	Object visittestbidirectionalrelation__ConceptC(ConceptC it);

	Object visittestbidirectionalrelation__ConceptD(ConceptD it);

	Object visittestbidirectionalrelation__ConceptE(ConceptE it);

	Object visittestbidirectionalrelation__ConceptF(ConceptF it);

	Object visittestbidirectionalrelation__ConceptG(ConceptG it);
}
