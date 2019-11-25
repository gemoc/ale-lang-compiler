package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Method;

public class MethodCallRootNode extends RootNode {
  @Child
  private Method it;

  public MethodCallRootNode(Method it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    miniJava.interpreter.miniJava.State state = (miniJava.interpreter.miniJava.State) frame.getArguments()[0];
    it.call(state);
    return null;
  }
}
