package emfswitch;

import emfswitch.operation.EAccOperation;
import java.lang.Object;
import java.lang.Override;
import testaccessors.EAcc;
import testaccessors.util.TestaccessorsSwitch;

public class SwitchImplementation extends TestaccessorsSwitch<Object> {
	@Override
	public Object caseEAcc(EAcc it) {
		return new EAccOperation(it, this);
	}
}
