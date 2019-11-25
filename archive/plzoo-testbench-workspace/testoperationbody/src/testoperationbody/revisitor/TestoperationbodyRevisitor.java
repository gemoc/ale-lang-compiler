package testoperationbody.revisitor;

public interface TestoperationbodyRevisitor<Testoperationbody__ChildAT extends Testoperationbody__ParentT, Testoperationbody__ChildBT extends Testoperationbody__ParentT, Testoperationbody__ConceptAT, Testoperationbody__MainT, Testoperationbody__ParentT> {
	Testoperationbody__ChildAT testoperationbody__ChildA(final testoperationbody.ChildA it);
	Testoperationbody__ChildBT testoperationbody__ChildB(final testoperationbody.ChildB it);
	Testoperationbody__ConceptAT testoperationbody__ConceptA(final testoperationbody.ConceptA it);
	Testoperationbody__MainT testoperationbody__Main(final testoperationbody.Main it);

	default Testoperationbody__ChildAT $(final testoperationbody.ChildA it) {
		return testoperationbody__ChildA(it);
	}
	default Testoperationbody__ChildBT $(final testoperationbody.ChildB it) {
		return testoperationbody__ChildB(it);
	}
	default Testoperationbody__ConceptAT $(final testoperationbody.ConceptA it) {
		return testoperationbody__ConceptA(it);
	}
	default Testoperationbody__MainT $(final testoperationbody.Main it) {
		return testoperationbody__Main(it);
	}
	default Testoperationbody__ParentT $(final testoperationbody.Parent it) {
		if (it.getClass() == testoperationbody.impl.ChildAImpl.class)
			return testoperationbody__ChildA((testoperationbody.ChildA) it);
		if (it.getClass() == testoperationbody.impl.ChildBImpl.class)
			return testoperationbody__ChildB((testoperationbody.ChildB) it);
		return null;
	}
}
