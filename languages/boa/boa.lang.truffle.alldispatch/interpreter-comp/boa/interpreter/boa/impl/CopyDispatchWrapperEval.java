package boa.interpreter.boa.impl;

import boa.interpreter.boa.Copy;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class CopyDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected CopyDispatchWrapperEval(Copy it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("CopyDispatchWrapperEval_7.001224586354795E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new CopyEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
