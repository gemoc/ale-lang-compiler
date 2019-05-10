package x.y.z.revisitor;

public interface FunctioncallRevisitor<Functioncall__ConceptAT, Functioncall__ConceptBT extends Functioncall__ConceptAT, Functioncall__ConceptCT> {
	Functioncall__ConceptAT functioncall__ConceptA(final x.y.z.functioncall.ConceptA it);
	Functioncall__ConceptBT functioncall__ConceptB(final x.y.z.functioncall.ConceptB it);
	Functioncall__ConceptCT functioncall__ConceptC(final x.y.z.functioncall.ConceptC it);

	default Functioncall__ConceptAT $(final x.y.z.functioncall.ConceptA it) {
		if (it.getClass() == x.y.z.functioncall.impl.ConceptBImpl.class)
			return functioncall__ConceptB((x.y.z.functioncall.ConceptB) it);
		return functioncall__ConceptA(it);
	}
	default Functioncall__ConceptBT $(final x.y.z.functioncall.ConceptB it) {
		return functioncall__ConceptB(it);
	}
	default Functioncall__ConceptCT $(final x.y.z.functioncall.ConceptC it) {
		return functioncall__ConceptC(it);
	}
}
