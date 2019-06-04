package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.State;

public class StatePushNewFrameRootNode extends RootNode {
  @Child
  private State it;

  public StatePushNewFrameRootNode(State it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    miniJava.interpreter.miniJava.ObjectInstance receiver = (miniJava.interpreter.miniJava.ObjectInstance) frame.getArguments()[0];
    miniJava.interpreter.miniJava.Call c = (miniJava.interpreter.miniJava.Call) frame.getArguments()[1];
    miniJava.interpreter.miniJava.Context newContext = (miniJava.interpreter.miniJava.Context) frame.getArguments()[2];
    it.pushNewFrame(receiver, c, newContext);
    return null;
  }
}
