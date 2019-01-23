package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import fsm.interpreter.fsm.Buffer;

public class BufferDispatchWrapperDequeue {
  private RootCallTarget callTarget;

  private final CyclicAssumption callTargetStable;

  protected BufferDispatchWrapperDequeue(Buffer it) {
    this.callTargetStable = new CyclicAssumption("BufferDispatchWrapperDequeue_7.030561954188234E7");
    this.callTarget = Truffle.getRuntime().createCallTarget(new BufferDequeueRootNode(it));
  }

  public RootCallTarget getCallTarget() {
    return callTarget;}

  public Assumption getCallTargetStable() {
    return callTargetStable.getAssumption();}
}
