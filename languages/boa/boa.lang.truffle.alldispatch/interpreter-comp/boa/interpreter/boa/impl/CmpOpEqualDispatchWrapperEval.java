package boa.interpreter.boa.impl;

import boa.interpreter.boa.CmpOpEqual;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class CmpOpEqualDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected CmpOpEqualDispatchWrapperEval(CmpOpEqual it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("CmpOpEqualDispatchWrapperEval_3.1271850129068602E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new CmpOpEqualEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
