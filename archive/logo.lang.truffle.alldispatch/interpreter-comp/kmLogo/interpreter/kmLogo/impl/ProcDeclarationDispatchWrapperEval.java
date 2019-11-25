package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.ProcDeclaration;

public class ProcDeclarationDispatchWrapperEval extends InstructionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ProcDeclarationDispatchWrapperEval(ProcDeclaration it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("ProcDeclarationDispatchWrapperEval_2127483.2898387318");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ProcDeclarationEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
