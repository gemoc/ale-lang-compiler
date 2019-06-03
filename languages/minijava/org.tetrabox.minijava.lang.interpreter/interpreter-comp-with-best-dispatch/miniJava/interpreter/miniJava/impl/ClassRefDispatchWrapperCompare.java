package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import miniJava.interpreter.miniJava.ClassRef;

public class ClassRefDispatchWrapperCompare extends TypeRefDispatchWrapperCompare {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected ClassRefDispatchWrapperCompare(ClassRef it) {
    super(it);
    this.callTargetStable = new CyclicAssumption("ClassRefDispatchWrapperCompare_4.1657267242917016E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new ClassRefCompareRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
