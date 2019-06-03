package boa.interpreter.boa.impl;

import boa.interpreter.boa.App;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class AppDispatchWrapperEval extends ExprDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected AppDispatchWrapperEval(App it) {
	  super(it);
    this.callTargetStable = new CyclicAssumption("AppDispatchWrapperEval_4915613.569402287");
    this.callTarget = Truffle.getRuntime().createCallTarget(new AppEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
