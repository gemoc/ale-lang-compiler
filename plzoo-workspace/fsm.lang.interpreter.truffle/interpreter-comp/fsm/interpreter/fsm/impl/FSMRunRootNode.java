package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import fsm.interpreter.fsm.FSM;
import java.lang.Object;
import java.lang.Override;

public class FSMRunRootNode extends RootNode {
  @Child
  private FSM it;

  public FSMRunRootNode(FSM it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    it.run();
    return null;
  }
}
