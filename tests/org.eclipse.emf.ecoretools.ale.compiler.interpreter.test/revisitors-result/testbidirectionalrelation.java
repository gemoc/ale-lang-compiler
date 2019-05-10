package testbidirectionalrelation.revisitor;

public interface TestbidirectionalrelationRevisitor<Testbidirectionalrelation__ConceptAT, Testbidirectionalrelation__ConceptBT, Testbidirectionalrelation__ConceptCT, Testbidirectionalrelation__ConceptDT, Testbidirectionalrelation__ConceptET, Testbidirectionalrelation__ConceptFT, Testbidirectionalrelation__ConceptGT> {
	Testbidirectionalrelation__ConceptAT testbidirectionalrelation__ConceptA(final testbidirectionalrelation.ConceptA it);
	Testbidirectionalrelation__ConceptBT testbidirectionalrelation__ConceptB(final testbidirectionalrelation.ConceptB it);
	Testbidirectionalrelation__ConceptCT testbidirectionalrelation__ConceptC(final testbidirectionalrelation.ConceptC it);
	Testbidirectionalrelation__ConceptDT testbidirectionalrelation__ConceptD(final testbidirectionalrelation.ConceptD it);
	Testbidirectionalrelation__ConceptET testbidirectionalrelation__ConceptE(final testbidirectionalrelation.ConceptE it);
	Testbidirectionalrelation__ConceptFT testbidirectionalrelation__ConceptF(final testbidirectionalrelation.ConceptF it);
	Testbidirectionalrelation__ConceptGT testbidirectionalrelation__ConceptG(final testbidirectionalrelation.ConceptG it);

	default Testbidirectionalrelation__ConceptAT $(final testbidirectionalrelation.ConceptA it) {
		return testbidirectionalrelation__ConceptA(it);
	}
	default Testbidirectionalrelation__ConceptBT $(final testbidirectionalrelation.ConceptB it) {
		return testbidirectionalrelation__ConceptB(it);
	}
	default Testbidirectionalrelation__ConceptCT $(final testbidirectionalrelation.ConceptC it) {
		return testbidirectionalrelation__ConceptC(it);
	}
	default Testbidirectionalrelation__ConceptDT $(final testbidirectionalrelation.ConceptD it) {
		return testbidirectionalrelation__ConceptD(it);
	}
	default Testbidirectionalrelation__ConceptET $(final testbidirectionalrelation.ConceptE it) {
		return testbidirectionalrelation__ConceptE(it);
	}
	default Testbidirectionalrelation__ConceptFT $(final testbidirectionalrelation.ConceptF it) {
		return testbidirectionalrelation__ConceptF(it);
	}
	default Testbidirectionalrelation__ConceptGT $(final testbidirectionalrelation.ConceptG it) {
		return testbidirectionalrelation__ConceptG(it);
	}
}
