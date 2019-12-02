package autocast.revisitor;

public interface AutocastRevisitor<Autocast__ConceptAT, Autocast__ConceptBT extends Autocast__ConceptAT, Autocast__ConceptCT> {
	Autocast__ConceptAT autocast__ConceptA(final autocast.ConceptA it);
	Autocast__ConceptBT autocast__ConceptB(final autocast.ConceptB it);
	Autocast__ConceptCT autocast__ConceptC(final autocast.ConceptC it);

	default Autocast__ConceptAT $(final autocast.ConceptA it) {
		if (it.getClass() == autocast.impl.ConceptBImpl.class)
			return autocast__ConceptB((autocast.ConceptB) it);
		return autocast__ConceptA(it);
	}
	default Autocast__ConceptBT $(final autocast.ConceptB it) {
		return autocast__ConceptB(it);
	}
	default Autocast__ConceptCT $(final autocast.ConceptC it) {
		return autocast__ConceptC(it);
	}
}
