package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class TransitionDispatchWrapperFire {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected TransitionDispatchWrapperFire(TransitionImpl it) {
		this.callTargetStable = new CyclicAssumption("TransitionDispatchWrapperFire_5.176466007196115E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new TransitionFireRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();}
}
