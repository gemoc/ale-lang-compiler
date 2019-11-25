package test1.revisitor;

public interface Test1Revisitor<Test1__ConceptAT, Test1__ConceptBT extends Test1__ConceptAT> {
	Test1__ConceptAT test1__ConceptA(final test1.ConceptA it);
	Test1__ConceptBT test1__ConceptB(final test1.ConceptB it);

	default Test1__ConceptAT $(final test1.ConceptA it) {
		if (it.getClass() == test1.impl.ConceptBImpl.class)
			return test1__ConceptB((test1.ConceptB) it);
		return test1__ConceptA(it);
	}
	default Test1__ConceptBT $(final test1.ConceptB it) {
		return test1__ConceptB(it);
	}
}
