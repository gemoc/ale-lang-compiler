package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ProcDeclarationDispatchWrapperDeval {
	private RootCallTarget callTarget;

	private final CyclicAssumption callTargetStable;

	protected ProcDeclarationDispatchWrapperDeval(ProcDeclarationImpl it) {
		this.callTargetStable = new CyclicAssumption("ProcDeclarationDispatchWrapperDeval_6.711739642530699E7");
		this.callTarget = Truffle.getRuntime().createCallTarget(new ProcDeclarationDevalRootNode(it));
	}

	public RootCallTarget getCallTarget() {
		return callTarget;}

	public Assumption getCallTargetStable() {
		return callTargetStable.getAssumption();}
}
