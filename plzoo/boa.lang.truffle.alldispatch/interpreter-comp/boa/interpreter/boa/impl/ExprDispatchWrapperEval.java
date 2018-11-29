package boa.interpreter.boa.impl;

import boa.interpreter.boa.Expr;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class ExprDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ExprDispatchWrapperEval(Expr it) {
    this.callTargetStable = new CyclicAssumption("ExprDispatchWrapperEval_9.724937721539806E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ExprEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
