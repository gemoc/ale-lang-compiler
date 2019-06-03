package boa.interpreter.boa.impl;

import boa.interpreter.boa.Def;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class DefDispatchWrapperNextLine extends TopLevelCmdDispatchWrapperNextLine {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected DefDispatchWrapperNextLine(Def it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("DefDispatchWrapperNextLine_9.866139214767528E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new DefNextLineRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
