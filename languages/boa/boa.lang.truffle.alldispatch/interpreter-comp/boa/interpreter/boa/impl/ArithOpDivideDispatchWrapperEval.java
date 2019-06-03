package boa.interpreter.boa.impl;

import boa.interpreter.boa.ArithOpDivide;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ArithOpDivideDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected ArithOpDivideDispatchWrapperEval(ArithOpDivide it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("ArithOpDivideDispatchWrapperEval_9.997277377148588E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new ArithOpDivideEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
