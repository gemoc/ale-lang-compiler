package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import fsm.interpreter.fsm.State;
import java.lang.Object;
import java.lang.Override;

public class StateStepRootNode extends RootNode {
  @Child
  private State it;

  public StateStepRootNode(State it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    java.lang.String inputString = (java.lang.String) frame.getArguments()[0];
    it.step(inputString);
    return null;
  }
}
