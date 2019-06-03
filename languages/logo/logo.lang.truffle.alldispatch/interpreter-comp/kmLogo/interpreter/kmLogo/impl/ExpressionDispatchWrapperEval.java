package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import kmLogo.interpreter.kmLogo.Expression;

public class ExpressionDispatchWrapperEval extends InstructionDispatchWrapperEval {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ExpressionDispatchWrapperEval(Expression it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("ExpressionDispatchWrapperEval_9.559573853550658E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ExpressionEvalRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
