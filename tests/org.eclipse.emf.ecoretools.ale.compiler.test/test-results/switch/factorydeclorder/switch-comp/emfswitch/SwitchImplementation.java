package emfswitch;

import emfswitch.operation.AOperation;
import emfswitch.operation.BOperation;
import emfswitch.operation.COperation;
import emfswitch.operation.DOperation;
import factorydeclorder.A;
import factorydeclorder.B;
import factorydeclorder.C;
import factorydeclorder.D;
import factorydeclorder.util.FactorydeclorderSwitch;
import java.lang.Object;
import java.lang.Override;

public class SwitchImplementation extends FactorydeclorderSwitch<Object> {
	@Override
	public Object caseC(C it) {
		return new COperation(it, this);
	}

	@Override
	public Object caseA(A it) {
		return new AOperation(it, this);
	}

	@Override
	public Object caseB(B it) {
		return new BOperation(it, this);
	}

	@Override
	public Object caseD(D it) {
		return new DOperation(it, this);
	}
}
