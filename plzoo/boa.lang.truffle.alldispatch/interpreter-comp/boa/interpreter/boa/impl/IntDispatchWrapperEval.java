package boa.interpreter.boa.impl;

import boa.interpreter.boa.Int;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class IntDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected IntDispatchWrapperEval(Int it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("IntDispatchWrapperEval_4.523117276334008E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new IntEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
