package boa.interpreter.boa.impl;

import boa.interpreter.boa.Skip;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class SkipDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected SkipDispatchWrapperEval(Skip it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("SkipDispatchWrapperEval_5.6273202893180735E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new SkipEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
