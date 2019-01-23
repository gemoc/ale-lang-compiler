package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.ProcDeclaration;

public class ProcDeclarationDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ProcDeclarationDispatchWrapperEval(ProcDeclaration it) {
    this.callTargetStable = new CyclicAssumption("ProcDeclarationDispatchWrapperEval_7.321632676806565E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ProcDeclarationEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
