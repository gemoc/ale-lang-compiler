package boa.interpreter.boa.impl;

import boa.interpreter.boa.ArithOpMinus;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ArithOpMinusDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ArithOpMinusDispatchWrapperEval(ArithOpMinus it) {
    this.callTargetStable = new CyclicAssumption("ArithOpMinusDispatchWrapperEval_1.5710937644129144E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ArithOpMinusEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
