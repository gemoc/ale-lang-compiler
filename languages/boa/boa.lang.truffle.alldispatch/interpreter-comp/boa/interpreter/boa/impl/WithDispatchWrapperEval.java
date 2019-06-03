package boa.interpreter.boa.impl;

import boa.interpreter.boa.With;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class WithDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected WithDispatchWrapperEval(With it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("WithDispatchWrapperEval_3.424122982426371E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new WithEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
