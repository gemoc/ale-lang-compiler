package test1unique.revisitor;

public interface Test1uniqueRevisitor<Test1unique__ConceptAT> {
	Test1unique__ConceptAT test1unique__ConceptA(final test1unique.ConceptA it);

	default Test1unique__ConceptAT $(final test1unique.ConceptA it) {
		return test1unique__ConceptA(it);
	}
}
