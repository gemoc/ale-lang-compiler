package emfswitch;

import emapvselistentry.NewEClass1;
import emapvselistentry.util.EmapvselistentrySwitch;
import emfswitch.operation.NewEClass1Operation;
import java.lang.Object;
import java.lang.Override;

public class SwitchImplementation extends EmapvselistentrySwitch<Object> {
	@Override
	public Object caseNewEClass1(NewEClass1 it) {
		return new NewEClass1Operation(it, this);
	}
}
