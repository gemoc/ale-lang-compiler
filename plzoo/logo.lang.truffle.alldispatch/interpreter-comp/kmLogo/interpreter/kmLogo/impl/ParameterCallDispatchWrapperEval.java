package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.ParameterCall;

public class ParameterCallDispatchWrapperEval extends ExpressionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ParameterCallDispatchWrapperEval(ParameterCall it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("ParameterCallDispatchWrapperEval_8.778006872542256E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ParameterCallEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
