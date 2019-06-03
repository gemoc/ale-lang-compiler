package boa.interpreter.boa.impl;

import boa.interpreter.boa.Not;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class NotDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected NotDispatchWrapperEval(Not it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("NotDispatchWrapperEval_3.725962933092851E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new NotEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
