package boa.interpreter.boa.impl;

import boa.interpreter.boa.Assign;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class AssignDispatchWrapperEval extends ExprDispatchWrapperEval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected AssignDispatchWrapperEval(Assign it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("AssignDispatchWrapperEval_6.839300814921567E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new AssignEvalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
