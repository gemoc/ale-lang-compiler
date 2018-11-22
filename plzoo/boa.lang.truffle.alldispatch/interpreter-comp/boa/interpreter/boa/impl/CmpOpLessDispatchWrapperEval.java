package boa.interpreter.boa.impl;

import boa.interpreter.boa.CmpOpLess;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class CmpOpLessDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected CmpOpLessDispatchWrapperEval(CmpOpLess it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("CmpOpLessDispatchWrapperEval_3.3395194556468695E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new CmpOpLessEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
