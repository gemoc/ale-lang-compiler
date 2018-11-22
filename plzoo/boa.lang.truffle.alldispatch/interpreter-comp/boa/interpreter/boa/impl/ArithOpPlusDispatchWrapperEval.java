package boa.interpreter.boa.impl;

import boa.interpreter.boa.ArithOpPlus;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ArithOpPlusDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected ArithOpPlusDispatchWrapperEval(ArithOpPlus it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("ArithOpPlusDispatchWrapperEval_1.8820520727457255E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new ArithOpPlusEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
