package boa.interpreter.boa.impl;

import boa.interpreter.boa.Expr;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ExprDispatchWrapperNextLine extends TopLevelCmdDispatchWrapperNextLine {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected ExprDispatchWrapperNextLine(Expr it) {
		super(it);
		this.callTargetStable = new CyclicAssumption("ExprDispatchWrapperNextLine_1.1614589372349491E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new ExprNextLineRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;
	}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();
	}
}
