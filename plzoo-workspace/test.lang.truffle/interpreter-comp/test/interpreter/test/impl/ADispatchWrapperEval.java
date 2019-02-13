package test.interpreter.test.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import test.interpreter.test.A;

public class ADispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ADispatchWrapperEval(A it) {
    this.callTargetStable = new CyclicAssumption("ADispatchWrapperEval_5.2691176557542406E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new AEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
