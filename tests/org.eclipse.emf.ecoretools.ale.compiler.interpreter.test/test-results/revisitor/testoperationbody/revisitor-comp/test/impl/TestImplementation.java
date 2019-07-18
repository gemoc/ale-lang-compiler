package test.impl;

import test.impl.operation.ChildAOp;
import test.impl.operation.ChildBOp;
import test.impl.operation.ConceptAOp;
import test.impl.operation.MainOp;
import test.impl.operation.ParentOp;
import test.impl.operation.impl.ChildAOpImpl;
import test.impl.operation.impl.ChildBOpImpl;
import test.impl.operation.impl.ConceptAOpImpl;
import test.impl.operation.impl.MainOpImpl;
import test.impl.operation.impl.ParentOpImpl;
import testoperationbody.ChildA;
import testoperationbody.ChildB;
import testoperationbody.ConceptA;
import testoperationbody.Main;
import testoperationbody.Parent;
import testoperationbody.revisitor.TestoperationbodyRevisitor;

public interface TestImplementation extends TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> {
		default ChildAOp testoperationbody__ChildA(ChildA it) {
		return new ChildAOpImpl(it, this);
	}

	default ChildBOp testoperationbody__ChildB(ChildB it) {
		return new ChildBOpImpl(it, this);
	}

	default ConceptAOp testoperationbody__ConceptA(ConceptA it) {
		return new ConceptAOpImpl(it, this);
	}

	default MainOp testoperationbody__Main(Main it) {
		return new MainOpImpl(it, this);
	}

	default ParentOp testoperationbody__Parent(Parent it) {
		return new ParentOpImpl(it, this);
	}
}
