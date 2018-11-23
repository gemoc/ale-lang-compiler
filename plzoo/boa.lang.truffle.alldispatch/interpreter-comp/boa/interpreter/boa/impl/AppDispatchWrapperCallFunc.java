package boa.interpreter.boa.impl;

import boa.interpreter.boa.App;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class AppDispatchWrapperCallFunc {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected AppDispatchWrapperCallFunc(App it) {
    this.callTargetStable = new CyclicAssumption("AppDispatchWrapperCallFunc_5.639283166192364E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new AppCallFuncRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
