package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.TypeRef;

public class TypeRefDispatchWrapperCompare {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected TypeRefDispatchWrapperCompare(TypeRef it) {
    this.callTargetStable = new CyclicAssumption("TypeRefDispatchWrapperCompare_5.5536391287873425E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new TypeRefCompareRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
