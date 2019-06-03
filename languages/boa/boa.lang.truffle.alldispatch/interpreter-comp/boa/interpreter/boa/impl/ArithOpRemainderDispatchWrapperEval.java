package boa.interpreter.boa.impl;

import boa.interpreter.boa.ArithOpRemainder;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ArithOpRemainderDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected ArithOpRemainderDispatchWrapperEval(ArithOpRemainder it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("ArithOpRemainderDispatchWrapperEval_4.222878806583059E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new ArithOpRemainderEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
