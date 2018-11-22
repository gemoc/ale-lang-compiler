package boa.interpreter.boa.impl;

import boa.interpreter.boa.ArithOpMinus;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ArithOpMinusDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected ArithOpMinusDispatchWrapperEval(ArithOpMinus it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("ArithOpMinusDispatchWrapperEval_7.382611377474938E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new ArithOpMinusEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
