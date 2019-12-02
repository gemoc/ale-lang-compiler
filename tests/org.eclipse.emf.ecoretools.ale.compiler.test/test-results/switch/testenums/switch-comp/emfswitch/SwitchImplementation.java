package emfswitch;

import emfswitch.operation.RootOperation;
import java.lang.Object;
import java.lang.Override;
import testenums.Root;
import testenums.util.TestenumsSwitch;

public class SwitchImplementation extends TestenumsSwitch<Object> {
	@Override
	public Object caseRoot(Root it) {
		return new RootOperation(it, this);
	}
}
