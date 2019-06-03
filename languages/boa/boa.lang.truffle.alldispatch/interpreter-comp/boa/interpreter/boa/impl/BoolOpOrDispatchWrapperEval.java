package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoolOpOr;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class BoolOpOrDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected BoolOpOrDispatchWrapperEval(BoolOpOr it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("BoolOpOrDispatchWrapperEval_6.945729127012189E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new BoolOpOrEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
