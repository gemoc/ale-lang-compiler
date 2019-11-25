package test1.revisitor;

public interface Test1Revisitor<Test1__ConceptAT> {
	Test1__ConceptAT test1__ConceptA(final test1.ConceptA it);

	default Test1__ConceptAT $(final test1.ConceptA it) {
		return test1__ConceptA(it);
	}
}
