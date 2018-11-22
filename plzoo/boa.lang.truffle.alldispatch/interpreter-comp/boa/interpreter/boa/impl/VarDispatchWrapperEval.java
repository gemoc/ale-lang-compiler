package boa.interpreter.boa.impl;

import boa.interpreter.boa.Var;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class VarDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected VarDispatchWrapperEval(Var it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("VarDispatchWrapperEval_2346379.880265768");
		this.callTarget = Truffle.getRuntime().createCallTarget(new VarEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
