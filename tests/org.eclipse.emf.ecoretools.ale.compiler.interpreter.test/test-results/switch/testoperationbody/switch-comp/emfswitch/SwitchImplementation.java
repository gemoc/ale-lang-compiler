package emfswitch;

import emfswitch.operation.ChildAOperation;
import emfswitch.operation.ChildBOperation;
import emfswitch.operation.ConceptAOperation;
import emfswitch.operation.MainOperation;
import emfswitch.operation.ParentOperation;
import java.lang.Object;
import java.lang.Override;
import testoperationbody.ChildA;
import testoperationbody.ChildB;
import testoperationbody.ConceptA;
import testoperationbody.Main;
import testoperationbody.Parent;
import testoperationbody.util.TestoperationbodySwitch;

public class SwitchImplementation extends TestoperationbodySwitch<Object> {
	@Override
	public Object caseMain(Main it) {
		return new MainOperation(it, this);
	}

	@Override
	public Object caseConceptA(ConceptA it) {
		return new ConceptAOperation(it, this);
	}

	@Override
	public Object caseParent(Parent it) {
		return new ParentOperation(it, this);
	}

	@Override
	public Object caseChildA(ChildA it) {
		return new ChildAOperation(it, this);
	}

	@Override
	public Object caseChildB(ChildB it) {
		return new ChildBOperation(it, this);
	}
}
