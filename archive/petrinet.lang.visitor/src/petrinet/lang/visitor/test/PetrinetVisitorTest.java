package petrinet.lang.visitor.test;

import visitor.petrinet.visitor.petrinet.Petrinet;
import visitor.visitor.VisitorImplementation;
import visitor.visitor.operation.petrinet.PetrinetOperation;

public class PetrinetVisitorTest {
	public static void main(String[] args) {

		VisitorImplementation visitor = new VisitorImplementation();

		Petrinet model = ModelFactory.chainOfOne(10);
		System.out.println("CHAIN OF ONE");
		((PetrinetOperation) model.accept(visitor)).run();

		Petrinet model2 = ModelFactory.manyToOne(10);
		System.out.println("MABY TO ONE");
		((PetrinetOperation) model2.accept(visitor)).run();
	}
}
