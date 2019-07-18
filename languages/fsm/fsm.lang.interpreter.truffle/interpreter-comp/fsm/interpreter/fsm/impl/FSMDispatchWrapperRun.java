package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class FSMDispatchWrapperRun {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected FSMDispatchWrapperRun(FSMImpl it) {
		this.callTargetStable = new CyclicAssumption("FSMDispatchWrapperRun_5.7637268095510416E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new FSMRunRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();}
}
