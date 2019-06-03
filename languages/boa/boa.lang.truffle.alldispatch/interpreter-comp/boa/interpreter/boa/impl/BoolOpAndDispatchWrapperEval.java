package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoolOpAnd;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class BoolOpAndDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected BoolOpAndDispatchWrapperEval(BoolOpAnd it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("BoolOpAndDispatchWrapperEval_9.794378098348828E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new BoolOpAndEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
