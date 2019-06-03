package boa.interpreter.boa.impl;

import boa.interpreter.boa.ArithOpTimes;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ArithOpTimesDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected ArithOpTimesDispatchWrapperEval(ArithOpTimes it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("ArithOpTimesDispatchWrapperEval_5.061707682350517E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new ArithOpTimesEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
