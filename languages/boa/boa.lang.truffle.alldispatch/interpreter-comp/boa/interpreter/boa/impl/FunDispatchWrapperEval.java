package boa.interpreter.boa.impl;

import boa.interpreter.boa.Fun;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class FunDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected FunDispatchWrapperEval(Fun it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("FunDispatchWrapperEval_6.675374367659278E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new FunEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
